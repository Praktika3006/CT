/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

import java.util.ArrayList;

/**
 *
 * @author stiv
 */
public class DistanceTransformation {
    // Глубина залегания точек скелета, относительно поверхности дерева дыхательных
    // путей
    private int[][][] distanceScene = null; 
    // Длины ветвей скелета
    public int[][][] skeletalDistanceMap = null;
    // Корень скелета
    private Point root = null;
   
    
    /**
     * Удаление ненужных ветвей из скелета на основет трансформации расстояний
     * @param scene - исходная сцена, в которой записаны интенсивности
     * 9000 - интенсивность дерева дыхательных путей
     * 9998 - интенсивность скелета
     */
    public DistanceTransformation(short[][][] scene)
    {
        // Карта расстояний, в которой будут записаны глубина залегания точек дерева дыхательных путей
        this.distanceScene = new int[scene.length][scene[0].length][scene[0][0].length];
        // Нахождение корня скелета 
        this.FindRoot(scene);
        
        // Инициализация карты расстояний: Всем точкам принадлежащим дыхательным путям
        // присваиваем значение 2000000, а всем точкам, не принадлежащим дыхательным путям - 0
        System.out.println("Инициализация");
        for(int z = 0; z < scene.length; z++)
            for(int y = 0; y < scene[0].length; y++)
                for(int x = 0; x < scene[0][0].length; x++)
                {
                    if(scene[z][y][x] < 9000)
                        distanceScene[z][y][x] = 0;
                    else
                        distanceScene[z][y][x] = 2_000_000;
                }
        
        // Делаем прямой проход для вычисления глубины залегания для 
        // каждой точки с помощью 3D-шаблона. Совершается в направлении (0, 0, 0) -> (maxX, maxY, maxZ)
        System.out.println("Прямой проход");
        for(int z = 0; z < scene.length; z++)
            for(int y = 0; y < scene[0].length; y++)
                for(int x = 0; x < scene[0][0].length; x++)
                {
                    this.ComputingForwardDistance(x, y, z, scene, this.distanceScene);
                }
        
        // Делаем обратный проход для вычисления глубины залегания для 
        // каждой точки с помощью 3D-шаблона. Совершается в направлении (maxX, maxY, maxZ)->(0, 0, 0)  
        System.out.println("Обратный проход");
        for(int z = scene.length - 1; z >= 0; z--)
            for(int y = scene[0].length - 1; y >= 0 ; y--)
                for(int x = scene[0][0].length - 1; x >= 0 ; x--)
                {
                    this.ComputingBackwardDistance(x, y, z, scene, this.distanceScene);
                }
        
        int t1 = 100; // Максимальная длина удаляемых веток
        int td = 20; // Минимальная глубина залегания точки ветвления
        
        for(int i = 0; i < 3; i++)
        {
            // Инициализируем карту длин ветвей скелета
            this.SkeletalDistanceMap(scene, td);
            // Вычисляем длины ветвей скелета
            this.DistancePropagation(scene);
            // Удаляем побочные ветви
            this.BranchDeletion(scene, t1);
        }
        
        t1 = 30; // Максимальная длина удаляемых веток
        td = 10; // Минимальная глубина залегания точки ветвления
        
        for(int i = 0; i < 3; i++)
        {
            // Инициализируем карту длин ветвей скелета
            this.SkeletalDistanceMap(scene, td);
            // Вычисляем длины ветвей скелета
            this.DistancePropagation(scene);
            // Удаляем побочные ветви
            this.BranchDeletion(scene, t1);
        }
        
        t1 = 10; // Максимальная длина удаляемых веток
        td = 0; // Минимальная глубина залегания точки ветвления
        
        for(int i = 0; i < 3; i++)
        {
            // Инициализируем карту длин ветвей скелета
            this.SkeletalDistanceMap(scene, td);
            // Вычисляем длины ветвей скелета
            this.DistancePropagation(scene);
            // Удаляем побочные ветви
            this.BranchDeletion(scene, t1);
        }
    }
    
    /**
     * Нахождение корня скелета.
     * Находим первый воксель, принадлежащий скелету - он и будет корнем.
     * @param scene - сцена, в которой хранятся интенсивности
     */
    private void FindRoot(short[][][] scene)
    {
        // Прохождение по всей сцене
        for(int z = 0; z < scene.length; z++)
            for(int y = 0; y < scene[0].length; y++)
                for(int x = 0; x < scene[0][0].length; x++)
                    // Если рассматриваемый воксель принадлежит скелету
                    if(scene[z][y][x] > 9990)
                    {
                        // Назначаем его корнем.
                        root = new Point(x, y, z);
                        return;
                    }
    }
    
    
    /**
     * Определяем можно ли удалить точку, у которой есть два соседа
     * @param ox - координата x рассматриваемой точки
     * @param oy - координата y рассматриваемой точки
     * @param oz - координата z рассматриваемой точки
     * @param scene - исходная трехмерная сцена, в которой записаны интенсивности
     * @return возвращает true, если у точки имеются два соседа, и при этом ее можно удалить
     *          и false - в ином случае
     */
    private boolean IsDeletableLinePoint(int ox, int oy, int oz, short[][][] scene)
    {
        // Если рассматриваемая точка является конечной точкой или точкой ветвления
        if(this.IsEndpoint(ox, oy, oz, scene) || this.IsBranchPoint(ox, oy, oz, scene))
            // то завершаем работу функции
            return false;
        
        // Проверяются является ли воксель крайним к границам сцены. Если да - мы
        // ограничиваем участок рассмотрения.
        int minX = 0, minY = 0, minZ = 0, maxX = 0, maxY = 0, maxZ = 0;
        
        if(ox - 1 < 0)
            minX = 0;
        else
            minX = ox - 1;
        
        if(ox + 1 >= scene[0][0].length)
            maxX = ox;
        else
            maxX = ox + 1;
        
        if(oy - 1 < 0)
            minY = 0;
        else
            minY = oy - 1;
        
        if(oy + 1 >= scene[0].length)
            maxY = oy;
        else
            maxY = oy + 1;
  
        if(oz - 1 < 0)
            minZ = 0;
        else
            minZ = oz - 1;
        
        if(oz + 1 >= scene.length)
            maxZ = oz;
        else
            maxZ = oz + 1;
        
        ArrayList<Point> points = new ArrayList<Point>(); // Точки, 26-соседние с данным вокселем
        // Проходим по всей 26-окрестности данной точки
        for(int z = minZ; z <= maxZ; z++)
            for(int y = minY; y <= maxY; y++)
                for(int x = minX; x <= maxX; x++)
                {
                    // Если точка из окрестности принадлежит скелету и она не является
                    // центральной точкой окрестности
                    if(scene[z][y][x] > 9990 && (x != ox || y != oy || z != oz))
                        // то добавляем ее в список соседей
                        points.add(new Point(x, y, z));
                }
        
        // Если две соседние точки располагаются рядом друг с другом
        if(Math.sqrt(Math.pow(points.get(0).GetX() - points.get(1).GetX(), 2) + 
                        Math.pow(points.get(0).GetY() - points.get(1).GetY(), 2) +
                        Math.pow(points.get(0).GetZ() - points.get(1).GetZ(), 2)) < 1.8)
            // то рассматриваемую точку можно удалить
            return true;
        else
            return false;       
    }
    
    /**
     * Определяем можно ли удалить точку, у которой есть более двух соседей
     * @param ox - координата x рассматриваемой точки
     * @param oy - координата y рассматриваемой точки
     * @param oz - координата z рассматриваемой точки
     * @param scene - исходная трехмерная сцена, в которой записаны интенсивности
     * @return возвращает true, если у точки имеются более двух соседей, и при этом ее можно удалить
     *          и false - в ином случае
     */
    private boolean IsDeletableBranchPoint(int ox, int oy, int oz, short[][][] scene)
    {
        // Если рассматриваемая точка не является точкой ветвления
        if(!this.IsBranchPoint(ox, oy, oz, scene))
            // прекращаем работу функции
            return false;
        
        // Проверяются является ли воксель крайним к границам сцены. Если да - мы
        // ограничиваем участок рассмотрения.
        int minX = 0, minY = 0, minZ = 0, maxX = 0, maxY = 0, maxZ = 0;
        
        if(ox - 1 < 0)
            minX = 0;
        else
            minX = ox - 1;
        
        if(ox + 1 >= scene[0][0].length)
            maxX = ox;
        else
            maxX = ox + 1;
        
        if(oy - 1 < 0)
            minY = 0;
        else
            minY = oy - 1;
        
        if(oy + 1 >= scene[0].length)
            maxY = oy;
        else
            maxY = oy + 1;
  
        if(oz - 1 < 0)
            minZ = 0;
        else
            minZ = oz - 1;
        
        if(oz + 1 >= scene.length)
            maxZ = oz;
        else
            maxZ = oz + 1;
        
        ArrayList<Point> points = new ArrayList<Point>(); // Точки, 26-соседние с данным вокселем
        
        // Проходим по всей 26-окрестности данной точки
        for(int z = minZ; z <= maxZ; z++)
            for(int y = minY; y <= maxY; y++)
                for(int x = minX; x <= maxX; x++)
                {
                    // Если точка из окрестности принадлежит скелету и она не является
                    // центральной точкой окрестности
                    if(scene[z][y][x] > 9990 && (x != ox || y != oy || z != oz))
                        // то добавляем ее в список соседей
                        points.add(new Point(x, y, z));
                }
        
        ArrayList<Point> points1 = new ArrayList<Point>(); // Точки, образующие самое большое соседство
        points1.add(points.get(0)); 
        ArrayList<Point> Q = new ArrayList<Point>(); // Очередь
        Q.add(points.get(0));
        
        // Проверяем, чтобы все точки окрестности были связаны друг с другом
        while(!Q.isEmpty()) //Пока очередь не пуста
        {
            Point p = Q.get(0); // Берем элемент из начала очереди
            Q.remove(p); // Удаляем первый элемент очереди
            
            // Для всех точек из 26-окрестности, соседних с данной точкой
            for(Point p1 : points)
            {
                // Если точка располагается рядом с точкой, взятой из очереди 
                if(Math.sqrt(Math.pow(p1.GetX() - p.GetX(), 2) + 
                        Math.pow(p1.GetY() - p.GetY(), 2) +
                        Math.pow(p1.GetZ() - p.GetZ(), 2)) < 1.8)
                    // и при этом она не содержится в самом большом соседстве
                    if(points1.indexOf(p1) == -1)
                    {
                        // Добавляем ее в самое большое соседство
                        points1.add(p1);
                        // Добавляем ее в очередь
                        Q.add(p1);
                    }
            }     
        }
        
        // Если размер самого большого соседства равен размеру 26-окрестности данной точки
        if(points1.size() == points.size())
            // Данную точку можно удалить
            return true;
        else
            return false;
    }
    
    /**
     * Вычисление глубины залегания для заданной точки при прямом проходе
     * Делается на основе 3D-шаблона
     * @param xo - координата x точки, для которой вычисляется глубина залегания
     * @param yo - координата y точки, для которой вычисляется глубина залегания
     * @param zo - координата z точки, для которой вычисляется глубина залегания
     * @param b - исходная сцена, в которой записаны интенсивности
     * @param distanceMap - 3D-сцена, в которой записана карта расстояний
     */
    private void ComputingForwardDistance(int xo, int yo, int zo, short[][][] b, int[][][] distanceMap)
    {
        int[] sum = new int[14]; // Массив, в котором будут хранится расстояния до
                                 // каждой точки из шаблона
        
        sum[13] = distanceMap[zo][yo][xo]; // Заносим в массив расстояний текущее значение 
                                           // расстояния
        
        // Заносим в массив расстояний до всех точек из шаблона
        if (xo - 1 >= 0)
            sum[12] = distanceMap[zo][yo][xo - 1] + 3;
        else
            sum[12] = 3;
        
        if (xo + 1 < b[0][0].length && yo - 1 >= 0)
            sum[11] = distanceMap[zo][yo - 1][xo + 1] + 4;
        else
            sum[11] = 4;
        
        if (yo - 1 >= 0)
            sum[10] = distanceMap[zo][yo - 1][xo] + 3;
        else
            sum[10] = 3;
        
        if (xo - 1 >= 0 && yo - 1 >= 0)
            sum[9] = distanceMap[zo][yo - 1][xo - 1] + 4;
        else
            sum[9] = 4;
        
        //++++++++++++++++++++++
        
        if (xo + 1 < b[0][0].length && yo + 1 < b[0].length && zo - 1 >= 0)
            sum[8] = distanceMap[zo - 1][yo + 1][xo + 1] + 5;
        else
            sum[8] = 5;
        
        if (yo + 1 < b[0].length && zo - 1 >= 0)
            sum[7] = distanceMap[zo - 1][yo + 1][xo] + 4;
        else
            sum[7] = 4;
        
        if (xo - 1 >= 0 && yo + 1 < b[0].length && zo - 1 >= 0)
            sum[6] = distanceMap[zo - 1][yo + 1][xo - 1] + 5;
        else
            sum[6] = 5;
        
        if (xo + 1 < b[0][0].length && zo - 1 >= 0)
            sum[5] = distanceMap[zo - 1][yo][xo + 1] + 4;
        else
            sum[5] = 4;
        
        if (zo - 1 >= 0)
            sum[4] = distanceMap[zo - 1][yo][xo] + 3;
        else
            sum[4] = 3;
        
        if (xo - 1 >= 0 && zo - 1 >= 0)
            sum[3] = distanceMap[zo - 1][yo][xo - 1] + 4;
        else
            sum[3] = 4;
        
        if (xo + 1 < b[0][0].length && yo - 1 >= 0 && zo - 1 >= 0)
            sum[2] = distanceMap[zo - 1][yo - 1][xo + 1] + 5;
        else
            sum[2] = 5;
        
        if (yo - 1 >= 0 && zo - 1 >= 0)
            sum[1] = distanceMap[zo - 1][yo - 1][xo] + 4;
        else
            sum[1] = 4;
        
        if (xo - 1 >= 0 && yo - 1 >= 0 && zo - 1 >= 0)
            sum[0] = distanceMap[zo - 1][yo - 1][xo - 1] + 5;
        else
            sum[0] = 5;
        //----------------------------------------------------
        
        // Выбираем из массива расстояний минимальное расстояние
        int minSum = Integer.MAX_VALUE;
        for(int i : sum)
        {
            if(i < minSum)
                minSum = i;
        }
        
        // Выбранное минимальное расстояние и будет глубиной залегания данной точки
        distanceMap[zo][yo][xo] = minSum;
    }
    
    /**
     * Вычисление глубины залегания для заданной точки при обратном проходе
     * Делается на основе 3D-шаблона
     * @param xo - координата x точки, для которой вычисляется глубина залегания
     * @param yo - координата y точки, для которой вычисляется глубина залегания
     * @param zo - координата z точки, для которой вычисляется глубина залегания
     * @param b - исходная сцена, в которой записаны интенсивности
     * @param distanceMap - 3D-сцена, в которой записана карта расстояний
     */
    private void ComputingBackwardDistance(int xo, int yo, int zo, short[][][] b, int[][][] distanceMap)
    {
        int[] sum = new int[14]; // Массив, в котором будут хранится расстояния до
                                 // каждой точки из шаблона
        
        sum[0] = distanceMap[zo][yo][xo];   // Заносим в массив расстояний текущее значение 
                                            // расстояния
        
        // Заносим в массив расстояний до всех точек из шаблона
        if (xo + 1 < b[0][0].length && yo + 1 < b[0].length && zo + 1 < b.length)
            sum[13] = distanceMap[zo + 1][yo + 1][xo + 1] + 5;
        else
            sum[13] = 5;
        
        if (yo + 1 < b[0].length && zo + 1 < b.length)
            sum[12] = distanceMap[zo + 1][yo + 1][xo] + 4;
        else
            sum[12] = 4;
        
        if (xo - 1 >= 0 && yo + 1 < b[0].length && zo + 1 < b.length)
            sum[11] = distanceMap[zo + 1][yo + 1][xo - 1] + 5;
        else
            sum[11] = 5;
        
        if (xo + 1 < b[0][0].length && zo + 1 < b.length)
            sum[10] = distanceMap[zo + 1][yo][xo + 1] + 4;
        else
            sum[10] = 4;
        
        if (zo + 1 < b.length)
            sum[9] = distanceMap[zo + 1][yo][xo] + 3;
        else
            sum[9] = 3;
        
        if (xo - 1 >= 0 && zo + 1 < b.length)
            sum[8] = distanceMap[zo + 1][yo][xo - 1] + 4;
        else
            sum[8] = 4;
        
        if (xo + 1 < b[0][0].length && yo - 1 >= 0 && zo + 1 < b.length)
            sum[7] = distanceMap[zo + 1][yo - 1][xo + 1] + 5;
        else
            sum[7] = 5;
        
        if (yo - 1 >= 0 && zo + 1 < b.length)
            sum[6] = distanceMap[zo + 1][yo - 1][xo] + 4;
        else
            sum[6] = 4;
        
        if (xo - 1 >= 0 && yo - 1 >= 0 && zo + 1 < b.length)
            sum[5] = distanceMap[zo + 1][yo - 1][xo - 1] + 5;
        else
            sum[5] = 5;
        
        //++++++++++++++
        
        if (xo + 1 < b[0][0].length && yo + 1 < b[0].length)
            sum[4] = distanceMap[zo][yo + 1][xo + 1] + 4;
        else
            sum[4] = 4;
        
        if (yo + 1 < b[0].length)
            sum[3] = distanceMap[zo][yo + 1][xo] + 3;
        else
            sum[3] = 3;
        
        if (xo - 1 >= 0 && yo + 1 < b[0].length)
            sum[2] = distanceMap[zo][yo + 1][xo - 1] + 4;
        else
            sum[2] = 4;
        
        if (xo + 1 < b[0][0].length)
            sum[1] = distanceMap[zo][yo][xo + 1] + 3;
        else
            sum[1] = 3;
        
        // ------------------------------------------------
        
        // Выбираем из массива расстояний минимальное расстояние
        int minSum = Integer.MAX_VALUE;
        for(int i : sum)
        {
            if(i < minSum)
                minSum = i;
        }
        
        // Выбранное минимальное расстояние и будет глубиной залегания данной точки 
        distanceMap[zo][yo][xo] = minSum;  
    }
    
    /**
     * Получение карты расстояний
     * @return возвращает трехмерную сцену, в которой записаны расстояния залегания точек
     * скелета
     */
    public int[][][] GetDistanceMap()
    {
        return this.distanceScene;
    }
    
    /**
     * Является ли данная точка скелета конечной точки.
     * Конечная точка должна иметь только одного 26-соседа.
     * @param ox - координата x рассматриваемой точки
     * @param oy - координата y рассматриваемой точки
     * @param oz - координата z рассматриваемой точки
     * @param scene - трехмерная сцена, в которой записаны интенсивности
     * @return возвращается true - если точка является конечной и false - в ином случае
     */
    private boolean IsEndpoint(int ox, int oy, int oz, short[][][] scene)
    {
        // Проверяются является ли воксель крайним к границам сцены. Если да - мы
        // ограничиваем участок рассмотрения.
        int minX = 0, minY = 0, minZ = 0, maxX = 0, maxY = 0, maxZ = 0;
        
        if(ox - 1 < 0)
            minX = 0;
        else
            minX = ox - 1;
        
        if(ox + 1 >= scene[0][0].length)
            maxX = ox;
        else
            maxX = ox + 1;
        
        if(oy - 1 < 0)
            minY = 0;
        else
            minY = oy - 1;
        
        if(oy + 1 >= scene[0].length)
            maxY = oy;
        else
            maxY = oy + 1;
  
        if(oz - 1 < 0)
            minZ = 0;
        else
            minZ = oz - 1;
        
        if(oz + 1 >= scene.length)
            maxZ = oz;
        else
            maxZ = oz + 1;
        
        int countNeightbors = 0; // Число соседей
        // Проходим по участку рассмотрения (26-окрестность рассматриваемой точки)
        for(int z = minZ; z <= maxZ; z++)
            for(int y = minY; y <= maxY; y++)
                for(int x = minX; x <= maxX; x++)
                {
                    if(scene[z][y][x] > 9990) // Если соседняя точка принадлежит скелету
                        countNeightbors++; // Увеличиваем число соседей.
                }
        
        if(countNeightbors == 2) // Если число соседей - 1 и +1 сама точка
            // то точка является конечной
            return true;
        else
            // точка не является конечной
            return false;      
    }
    
    /**
     * Проверяем является ли точка точкой ветвления
     * У точки ыетвления должно быть больше, чем 2 соседа
     * @param ox - координата x рассматриваемой точки
     * @param oy - координата y рассматриваемой точки
     * @param oz - координата z рассматриваемой точки
     * @param scene - трехмерная сцена, в которой записаны интенсивности
     * @return возвращается true - если точка является точкой ветвления и false - в ином случае
     */
    private boolean IsBranchPoint(int ox, int oy, int oz, short[][][] scene)
    {
        // Проверяются является ли воксель крайним к границам сцены. Если да - мы
        // ограничиваем участок рассмотрения.
        int minX = 0, minY = 0, minZ = 0, maxX = 0, maxY = 0, maxZ = 0;
        
        if(ox - 1 < 0)
            minX = 0;
        else
            minX = ox - 1;
        
        if(ox + 1 >= scene[0][0].length)
            maxX = ox;
        else
            maxX = ox + 1;
        
        if(oy - 1 < 0)
            minY = 0;
        else
            minY = oy - 1;
        
        if(oy + 1 >= scene[0].length)
            maxY = oy;
        else
            maxY = oy + 1;
  
        if(oz - 1 < 0)
            minZ = 0;
        else
            minZ = oz - 1;
        
        if(oz + 1 >= scene.length)
            maxZ = oz;
        else
            maxZ = oz + 1;
        
        int countNeightbors = 0; // Число соседей
        // Проходим по участку рассмотрения (26-окрестность рассматриваемой точки)
        for(int z = minZ; z <= maxZ; z++)
            for(int y = minY; y <= maxY; y++)
                for(int x = minX; x <= maxX; x++)
                {
                    if(scene[z][y][x] == 9998)
                        countNeightbors++;
                }
        
        if(countNeightbors > 3) // Если число соседей больше чем 2 и +1 сама точка
            // то точка является точкой ветвления
            return true;
        else
            // то точка не является точкой ветвления
            return false;      
    }
    
    /**
     * Проверка является ли данная точка 0-точкой
     * @param ox - координата x рассматриваемой точки
     * @param oy - координата y рассматриваемой точки
     * @param oz - координата z рассматриваемой точки
     * @param td - минимальная глубина залегания точки
     * @param scene - трехмерная сцена, в которой записаны интенсивности
     * @return возвращается true - если точка является 0-точкой и false - в ином случае
     */
    private boolean Is0Point(int ox, int oy, int oz, int td, short[][][] scene) {
        // Если рассматриваемая точка является точкой ветвления
        // и ее глубина залегания не менее чем td, то эта точка является 0-точкой
        if (this.IsBranchPoint(ox, oy, oz, scene) 
                && this.distanceScene[oz][oy][ox] >= td) {
            return true;
        }
        return false;
    }
    
    /**
     * Проверка является ли данная точка B-точкой
     * @param ox - координата x рассматриваемой точки
     * @param oy - координата y рассматриваемой точки
     * @param oz - координата z рассматриваемой точки
     * @param td - минимальная глубина залегания точки
     * @param scene - трехмерная сцена, в которой записаны интенсивности
     * @return возвращается true - если точка является B-точкой и false - в ином случае
     */
    private boolean IsBPoint(int ox, int oy, int oz, int td, short[][][] scene) {
        // Если рассматриваемая точка является точкой ветвления
        // и ее глубина залегания меньше чем td, то эта точка является B-точкой
        if (this.IsBranchPoint(ox, oy, oz, scene) 
                && this.distanceScene[oz][oy][ox] < td) {
            return true;
        }
        
        // Корень скелета тоже является B-точкой
        if(ox == this.root.GetX() && 
                oy == this.root.GetY() && 
                oz == this.root.GetZ()) {
            return true;
        }
        
        return false;            
    }
    
    /**
     * Инициализация карты расстояний для скелета, чтобы с ее помощью затем определить длину
     * ветвей скелета.
     * @param scene - исходная трехмерная сцена, в которой содержатся значения интенсивностей
     * @param td - минимальная глубина залегания точки ветвления
     */
    private void SkeletalDistanceMap(short[][][] scene, int td)
    {
        // Создание карты расстояний для скелета
        this.skeletalDistanceMap = new int[scene.length][scene[0].length][scene[0][0].length];
        
        // Проходим по всей сцене
        for(int z = 0; z < scene.length; z++)
            for(int y = 0; y < scene[0].length; y++)
                for(int x = 0; x < scene[0][0].length; x++)
                {
                    // Если данный воксель относится к скелету
                    if(scene[z][y][x] == 9998)
                    {
                        // Если данный воксель является 0 - точкой
                        if(this.Is0Point(x, y, z, td, scene))
                            this.skeletalDistanceMap[z][y][x] = 0;
                        else
                        {
                            // Если данный воксель является B-точкой
                            if(this.IsBPoint(x, y, z, td, scene))
                                this.skeletalDistanceMap[z][y][x] = 1000000;
                            else
                                // Если данный воксель не является ни 0-точкой, ни B-точкой
                                this.skeletalDistanceMap[z][y][x] = 1500000;
                        }
                    }
                    else
                    {
                        // Если данный воксель не относится к скелету
                        this.skeletalDistanceMap[z][y][x] = 2000000;
                    }
                }
    }
    
    /**
     * Определение длин ветвей
     * @param scene - исходная трехмерная сцена, в которой содержатся значения интенсивностей
     */
    public void DistancePropagation(short[][][] scene)
    {
        for(int i = 0; i < 3; i++) {
            
            // Для всех точек скелета, которые не являются B-точками,
            // делаем прямой проход и считаем расстояние до 0-точки 
            for(int z = 0; z < scene.length; z++)
                for(int y = 0; y < scene[0].length; y++)
                    for(int x = 0; x < scene[0][0].length; x++)
                        if(scene[z][y][x] == 9998 && this.skeletalDistanceMap[z][y][x] != 1000000)
                        {
                            this.ComputingForwardDistance(x, y, z, scene, this.skeletalDistanceMap);
                        }
        
            // Для всех точек скелета, которые не являются B-точками,
            // делаем обратный проход и считаем расстояние до 0-точки
            for(int z = scene.length - 1; z >= 0; z--)
                for(int y = scene[0].length - 1; y >= 0 ; y--)
                    for(int x = scene[0][0].length - 1; x >= 0 ; x--)
                        if(scene[z][y][x] == 9998 && this.skeletalDistanceMap[z][y][x] != 1000000)
                        {
                            this.ComputingBackwardDistance(x, y, z, scene, this.skeletalDistanceMap);
                        }
        }
    }
    
/**
 * Функция удаления побочных веток дерева
 * @param scene трехмерная сцена со значениями интенсивностей
 * @param t1 максимальная длина удаляемых веток
 */    
    public void BranchDeletion(short[][][] scene, int t1)
    {
        // С каждой итерацией уменьшаем максимальную длину удаляемых веток на 1, пока не дойдем
        // до основной ветки
        for(int i = t1; i >= 0; i--)
        {
            // Проходим по всей сцене
            for(int z = 0; z < scene.length; z++)
                for(int y = 0; y < scene[0].length; y++)
                    for(int x = 0; x < scene[0][0].length; x++)
                        // Если воксель принадлежит скелету
                        if(scene[z][y][x] == 9998)
                            // Если воксель является конечной точкой скелета
                            if(this.IsEndpoint(x, y, z, scene) ||
                                    // Или у него есть две соседние токи и его можно удалить
                                    this.IsDeletableBranchPoint(x, y, z, scene) ||
                                    // Или у него есть более двух осседних точек и его можно удалить
                                    this.IsDeletableLinePoint(x, y, z, scene))
                            {
                                if(this.skeletalDistanceMap[z][y][x] == i)
                                    scene[z][y][x] = 9988;
                            }
        }
    }
}
