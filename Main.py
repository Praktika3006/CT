import dicom
import os, sys
import numpy
from matplotlib import pyplot, cm
from PyQt5.QtGui import *
from PyQt5.QtWidgets import *
from PyQt5.QtOpenGL import *
import math
from OpenGL.GL import *
from OpenGL.GLU import *
from OpenGL.GLUT import *
import Test


#------------------------------------------------------

PathDicom = "/Volumes/WININSTALL/manix"
lstFilesDCM = []
for dirName, subdirList, fileList in os.walk(PathDicom):
    for filename in fileList:
        if ".dcm" in filename.lower():
            lstFilesDCM.append(os.path.join(dirName, filename))

pixelMap = []


for file in lstFilesDCM:
    RefDs = dicom.read_file(file)
    pixelMap.append(RefDs.pixel_array)


# list_of_points = []
#
# for z in range(0, len(pixelMap) - 1, 5):
#     for y in range(0, len(pixelMap[0]) - 1, 5):
#         first = True
#         end_point = None
#         for x in range(0, len(pixelMap[0][0]) - 1, 5):
#             cof = pixelMap[z][y][x]
#             if cof > 1250 and cof < 1500:
#                 if first:
#                     first = False
#                     list_of_points.append((x, y, z, cof))
#                 else:
#                     end_point = (x, y, z, cof)
#             else:
#                 first = True
#                 if end_point:
#                     list_of_points.append(end_point)
#                 end_point = None
#
# triangles_list = []

poligons = []

dict = Test.variant1()

STEPX = 8
STEPY = 8
STEPZ = 8

Test.STEPX = STEPX
Test.STEPY = STEPY
Test.STEPZ = STEPZ

BOTTOM_LIMIT = 1250
TOP_LIMIT = 1500
MY_COLOR = QColor(255, 255, 240, 255)


for z in range(0, len(pixelMap) - 1 - STEPZ, STEPZ):
    for y in range(0, len(pixelMap[0]) - 1 - STEPY, STEPY):
        for x in range(0, len(pixelMap[0][0]) - 1 - STEPX, STEPX):
            str = "00000000"

            v1 = pixelMap[z][y][x]
            if v1 > BOTTOM_LIMIT and v1 < TOP_LIMIT:
                str = "1" + str[1:]

            v2 = pixelMap[z][y][x + STEPX]
            if v2 > BOTTOM_LIMIT and v2 < TOP_LIMIT:
                str = str[0] + "1" + str[2:]

            v3 = pixelMap[z][y + STEPY][x + STEPX]
            if v3 > BOTTOM_LIMIT and v3 < TOP_LIMIT:
                str = str[:2] + "1" + str[3:]

            v4 = pixelMap[z][y + STEPY][x]
            if v4 > BOTTOM_LIMIT and v4 < TOP_LIMIT:
                str = str[:3] + "1" + str[4:]

            v5 = pixelMap[z + STEPZ][y][x]
            if v5 > BOTTOM_LIMIT and v5 < TOP_LIMIT:
                str = str[:4] + "1" + str[5:]

            v6 = pixelMap[z + STEPZ][y][x + STEPX]
            if v6 > BOTTOM_LIMIT and v6 < TOP_LIMIT:
                str = str[:5] + "1" + str[6:]

            v7 = pixelMap[z + STEPZ][y + STEPY][x + STEPX]
            if v7 > BOTTOM_LIMIT and v7 < TOP_LIMIT:
                str = str[:6] + "1" + str[7]

            v8 = pixelMap[z + STEPZ][y + STEPY][x]
            if v8 > BOTTOM_LIMIT and v8 < TOP_LIMIT:
                str = str[:7] + "1"

            if str in dict.keys():
                poligons += dict[str]((x, y, z, MY_COLOR))



#------------------------------------------------------

class MainWindow(QGLWidget):

    def __init__(self):
        super(MainWindow, self).__init__()
        self.resize(300, 300)
        self.xRotation = 0.0;
        self.yRotation = 0.0;
        self.zRotation = 0.0;
        self.scale = 1;
        self.mousePos = None
        global pixelMap
        self.zl = len(pixelMap) // 2
        self.yl = len(pixelMap[0]) // 2
        self.xl = len(pixelMap[0][0]) // 2

    def initializeGL(self):
        self.qglClearColor(QColor(0, 0, 0))
        glEnable(GL_DEPTH_TEST)
        glShadeModel(GL_FLAT)
        glEnable(GL_CULL_FACE)
        glPolygonMode(GL_FRONT, GL_FILL)

    def resizeGL(self, p_int, p_int_1):
        glViewport(0, 0, p_int, p_int_1)
        glMatrixMode(GL_PROJECTION)
        glLoadIdentity()

    def paintGL(self):
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT)
        glMatrixMode(GL_MODELVIEW)
        glLoadIdentity()

        glScalef(self.scale, self.scale, self.scale)
        glRotatef(self.xRotation, 1.0, 0.0, 0.0)
        glRotatef(self.yRotation, 0.0, 1.0, 0.0)
        glRotatef(self.zRotation, 0.0, 0.0, 1.0)

        self.drawAxis()



        # global list_of_points
        # global color
        global poligons

        for poligon in poligons:
            self.qglColor(poligon[0][3])
            glBegin(GL_TRIANGLES)
            glVertex3f(1.0 / self.xl * (poligon[0][0] - self.xl),
                   1.0 / self.yl * (poligon[0][1] - self.yl),
                   1.0 / self.zl * (poligon[0][2] - self.zl))
            glVertex3f(1.0 / self.xl * (poligon[1][0] - self.xl),
                   1.0 / self.yl * (poligon[1][1] - self.yl),
                   1.0 / self.zl * (poligon[1][2] - self.zl))
            glVertex3f(1.0 / self.xl * (poligon[2][0] - self.xl),
                   1.0 / self.yl * (poligon[2][1] - self.yl),
                   1.0 / self.zl * (poligon[2][2] - self.zl))
            glEnd()



        # for point in  list_of_points:
        #     cof = math.ceil(255 / 4095 * point[3])
        #     color = QColor(255, 0, 0, 255)
        #     self.qglColor(color)
        #
        #
        #     glBegin(GL_POINTS)
        #     glVertex3f(1.0 / self.xl * (point[0] - self.xl),
        #                1.0 / self.yl * (point[1] - self.yl),
        #                1.0 / self.zl * (point[2] - self.zl))
        #     glEnd()

    def mousePressEvent(self, event):
        self.mousePos = event.pos()

    def mouseMoveEvent(self, event):
        self.xRotation += 180/self.scale * (event.y() - self.mousePos.y())/self.height()
        self.zRotation += 180/self.scale * (event.x() - self.mousePos.x())/self.width()
        self.mousePos = event.pos()
        self.updateGL()

    def mouseReleaseEvent(self, event):
        pass

    # def wheelEvent(self, event):
    #     if ((event.delta())>0):
    #         self.scale *=1.1
    #     else:
    #         if ((event.delta())<0):
    #             self.scale /= 1.1
    #     self.updateGL()

    def drawAxis(self):
        glLineWidth(3.0)
        glColor4f(1.0, 0.0, 0.0, 1.0)
        glBegin(GL_LINES)
        glVertex3f(1.0, 0.0, 0.0)
        glVertex3f(-1.0, 0.0, 0.0)
        glEnd()

        halfGreen = QColor(0, 128, 0, 255)
        self.qglColor(halfGreen)
        glBegin(GL_LINES)
        glVertex3f(0.0, 1.0, 0.0)
        glVertex3f(0.0, -1.0, 0.0)
        glEnd()
        glColor4f(0.0, 0.0, 1.0, 1.0)
        glBegin(GL_LINES)
        glVertex3f(0.0, 0.0, 1.0)
        glVertex3f(0.0, 0.0, -1.0)
        glEnd()


def main():
    app = QApplication(sys.argv)

    window = MainWindow()
    window.setWindowTitle("Qt OpenGL")
    window.setGeometry(100, 100, 500, 500)
    window.show()

    sys.exit(app.exec_())

if __name__ == "__main__": main()