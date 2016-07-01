STEPX = 1
STEPY = 1
STEPZ = 1

# Делаем все относительно точки V1 !!!!

def e1(vertex):
    return (vertex[0] + STEPX / 2, vertex[1], vertex[2], vertex[3])

def e2(vertex):
    return (vertex[0] + STEPX, vertex[1] + STEPY / 2, vertex[2], vertex[3])

def e3(vertex):
    return (vertex[0] + STEPX / 2, vertex[1] + STEPY, vertex[2], vertex[3])

def e4(vertex):
    return (vertex[0], vertex[1] + STEPY / 2, vertex[2], vertex[3])

def e5(vertex):
    return (vertex[0] + STEPX / 2, vertex[1], vertex[2] + STEPZ, vertex[3])

def e6(vertex):
    return (vertex[0] + STEPX, vertex[1] + STEPY / 2, vertex[2] + STEPZ, vertex[3])

def e7(vertex):
    return (vertex[0] + STEPX / 2, vertex[1] + STEPY, vertex[2] + STEPZ, vertex[3])

def e8(vertex):
    return (vertex[0], vertex[1] + STEPY / 2, vertex[2] + STEPZ, vertex[3])

def e9(vertex):
    return (vertex[0], vertex[1], vertex[2] + STEPZ / 2, vertex[3])

def e10(vertex):
    return (vertex[0] + STEPX, vertex[1], vertex[2] + STEPZ / 2, vertex[3])

def e11(vertex):
    return (vertex[0], vertex[1] + STEPY, vertex[2] + STEPZ / 2, vertex[3])

def e12(vertex):
    return (vertex[0] + STEPX, vertex[1] + STEPY, vertex[2] + STEPZ / 2, vertex[3])





def isosurface(vertex_array):

    if vertex_array[0] == None and \
        vertex_array[1] == None and \
        vertex_array[2] == None and \
        vertex_array[3] == None and \
        vertex_array[4] == None and \
        vertex_array[5] == None and \
        vertex_array[6] == None and \
        vertex_array[7] == None:
        return

    result = variant1(vertex_array)
    if result:
        return result

    result = variant2(vertex_array)
    if result:
        return result

# vertex = (x, y, z, cof)

#--------------------------------------------------------------------------------
# def variant1(vertex_array):
#     if vertex_array[0] != None and \
#         vertex_array[1] == None and \
#         vertex_array[2] == None and \
#         vertex_array[3] == None and \
#         vertex_array[4] == None and \
#         vertex_array[5] == None and \
#         vertex_array[6] == None and \
#         vertex_array[7] == None:
#         return [(
#             e4(vertex_array[0]),
#             e1(vertex_array[0]),
#             e9(vertex_array[0])
#         )]
#
#     if vertex_array[0] == None and \
#         vertex_array[1] != None and \
#         vertex_array[2] == None and \
#         vertex_array[3] == None and \
#         vertex_array[4] == None and \
#         vertex_array[5] == None and \
#         vertex_array[6] == None and \
#         vertex_array[7] == None:
#         return [(
#             e2(vertex_array[0]),
#             e10(vertex_array[0]),
#             e1(vertex_array[0])
#         )]
#
#     if vertex_array[0] == None and \
#         vertex_array[1] == None and \
#         vertex_array[2] != None and \
#         vertex_array[3] == None and \
#         vertex_array[4] == None and \
#         vertex_array[5] == None and \
#         vertex_array[6] == None and \
#         vertex_array[7] == None:
#         return [(
#             e3(vertex_array[0]),
#             e12(vertex_array[0]),
#             e2(vertex_array[0])
#         )]
#
#     if vertex_array[0] == None and \
#         vertex_array[1] == None and \
#         vertex_array[2] == None and \
#         vertex_array[3] != None and \
#         vertex_array[4] == None and \
#         vertex_array[5] == None and \
#         vertex_array[6] == None and \
#         vertex_array[7] == None:
#         return [(
#             e11(vertex_array[0]),
#             e3(vertex_array[0]),
#             e4(vertex_array[0])
#         )]
#
#
#     if vertex_array[0] == None and \
#         vertex_array[1] == None and \
#         vertex_array[2] == None and \
#         vertex_array[3] == None and \
#         vertex_array[4] != None and \
#         vertex_array[5] == None and \
#         vertex_array[6] == None and \
#         vertex_array[7] == None:
#         return [(
#             e8(vertex_array[0]),
#             e9(vertex_array[0]),
#             e5(vertex_array[0])
#         )]
#
#     if vertex_array[0] == None and \
#         vertex_array[1] == None and \
#         vertex_array[2] == None and \
#         vertex_array[3] == None and \
#         vertex_array[4] == None and \
#         vertex_array[5] != None and \
#         vertex_array[6] == None and \
#         vertex_array[7] == None:
#         return [(
#             e6(vertex_array[0]),
#             e5(vertex_array[0]),
#             e10(vertex_array[0])
#         )]
#
#     if vertex_array[0] == None and \
#         vertex_array[1] == None and \
#         vertex_array[2] == None and \
#         vertex_array[3] == None and \
#         vertex_array[4] == None and \
#         vertex_array[5] == None and \
#         vertex_array[6] != None and \
#         vertex_array[7] == None:
#         return [(
#             e7(vertex_array[0]),
#             e6(vertex_array[0]),
#             e12(vertex_array[0])
#         )]
#
#     if vertex_array[0] == None and \
#         vertex_array[1] == None and \
#         vertex_array[2] == None and \
#         vertex_array[3] == None and \
#         vertex_array[4] == None and \
#         vertex_array[5] == None and \
#         vertex_array[6] == None and \
#         vertex_array[7] != None:
#         return [(
#             e11(vertex_array[0]),
#             e8(vertex_array[0]),
#             e7(vertex_array[0])
#         )]


#--------------------------------------------------------------------------------

def variant2(vertex_array):
    if vertex_array[0] != None and \
        vertex_array[1] != None and \
        vertex_array[2] == None and \
        vertex_array[3] == None and \
        vertex_array[4] == None and \
        vertex_array[5] == None and \
        vertex_array[6] == None and \
        vertex_array[7] == None:
        return [(
            e4(vertex_array[0]),
            e2(vertex_array[0]),
            e9(vertex_array[0])
            ),
            (
            e2(vertex_array[0]),
            e10(vertex_array[0]),
            e9(vertex_array[0])
        )]


    if vertex_array[0] == None and \
        vertex_array[1] != None and \
        vertex_array[2] != None and \
        vertex_array[3] == None and \
        vertex_array[4] == None and \
        vertex_array[5] == None and \
        vertex_array[6] == None and \
        vertex_array[7] == None:
        return [(
            e1(vertex_array[0]),
            e3(vertex_array[0]),
            e10(vertex_array[0])
            ),
            (
            e10(vertex_array[0]),
            e3(vertex_array[0]),
            e12(vertex_array[0])
        )]


    if vertex_array[0] == None and \
        vertex_array[1] == None and \
        vertex_array[2] != None and \
        vertex_array[3] != None and \
        vertex_array[4] == None and \
        vertex_array[5] == None and \
        vertex_array[6] == None and \
        vertex_array[7] == None:
        return [(
            e4(vertex_array[0]),
            e11(vertex_array[0]),
            e12(vertex_array[0])
            ),
            (
            e12(vertex_array[0]),
            e2(vertex_array[0]),
            e4(vertex_array[0])
        )]


    if vertex_array[0] != None and \
        vertex_array[1] == None and \
        vertex_array[2] == None and \
        vertex_array[3] != None and \
        vertex_array[4] == None and \
        vertex_array[5] == None and \
        vertex_array[6] == None and \
        vertex_array[7] == None:
        return [(
            e11(vertex_array[0]),
            e3(vertex_array[0]),
            e9(vertex_array[0])
            ),
            (
            e9(vertex_array[0]),
            e3(vertex_array[0]),
            e1(vertex_array[0])
        )]

    if vertex_array[0] == None and \
        vertex_array[1] == None and \
        vertex_array[2] == None and \
        vertex_array[3] == None and \
        vertex_array[4] != None and \
        vertex_array[5] != None and \
        vertex_array[6] == None and \
        vertex_array[7] == None:
        return [(
            e8(vertex_array[0]),
            e9(vertex_array[0]),
            e10(vertex_array[0])
            ),
            (
            e6(vertex_array[0]),
            e8(vertex_array[0]),
            e10(vertex_array[0])
        )]

    if vertex_array[0] == None and \
        vertex_array[1] == None and \
        vertex_array[2] == None and \
        vertex_array[3] == None and \
        vertex_array[4] == None and \
        vertex_array[5] != None and \
        vertex_array[6] != None and \
        vertex_array[7] == None:
        return [(
            e7(vertex_array[0]),
            e5(vertex_array[0]),
            e12(vertex_array[0])
            ),
            (
            e12(vertex_array[0]),
            e5(vertex_array[0]),
            e10(vertex_array[0])
        )]


    if vertex_array[0] == None and \
        vertex_array[1] == None and \
        vertex_array[2] == None and \
        vertex_array[3] == None and \
        vertex_array[4] == None and \
        vertex_array[5] == None and \
        vertex_array[6] != None and \
        vertex_array[7] != None:
        return [(
            e11(vertex_array[0]),
            e8(vertex_array[0]),
            e12(vertex_array[0])
            ),
            (
            e12(vertex_array[0]),
            e8(vertex_array[0]),
            e6(vertex_array[0])
        )]


    if vertex_array[0] == None and \
        vertex_array[1] == None and \
        vertex_array[2] == None and \
        vertex_array[3] == None and \
        vertex_array[4] != None and \
        vertex_array[5] == None and \
        vertex_array[6] == None and \
        vertex_array[7] != None:
        return [(
            e11(vertex_array[0]),
            e9(vertex_array[0]),
            e5(vertex_array[0])
            ),
            (
            e7(vertex_array[0]),
            e11(vertex_array[0]),
            e5(vertex_array[0])
        )]

    if vertex_array[0] != None and \
        vertex_array[1] == None and \
        vertex_array[2] == None and \
        vertex_array[3] == None and \
        vertex_array[4] != None and \
        vertex_array[5] == None and \
        vertex_array[6] == None and \
        vertex_array[7] == None:
        return [(
            e8(vertex_array[0]),
            e4(vertex_array[0]),
            e1(vertex_array[0])
            ),
            (
            e8(vertex_array[0]),
            e1(vertex_array[0]),
            e5(vertex_array[0])
        )]

    if vertex_array[0] == None and \
        vertex_array[1] != None and \
        vertex_array[2] == None and \
        vertex_array[3] == None and \
        vertex_array[4] == None and \
        vertex_array[5] != None and \
        vertex_array[6] == None and \
        vertex_array[7] == None:
        return [(
            e2(vertex_array[0]),
            e6(vertex_array[0]),
            e5(vertex_array[0])
            ),
            (
            e5(vertex_array[0]),
            e1(vertex_array[0]),
            e2(vertex_array[0])
        )]


    if vertex_array[0] == None and \
        vertex_array[1] == None and \
        vertex_array[2] != None and \
        vertex_array[3] == None and \
        vertex_array[4] == None and \
        vertex_array[5] == None and \
        vertex_array[6] != None and \
        vertex_array[7] == None:
        return [(
            e7(vertex_array[0]),
            e3(vertex_array[0]),
            e6(vertex_array[0])
            ),
            (
            e3(vertex_array[0]),
            e2(vertex_array[0]),
            e6(vertex_array[0])
        )]


    if vertex_array[0] == None and \
        vertex_array[1] == None and \
        vertex_array[2] == None and \
        vertex_array[3] != None and \
        vertex_array[4] == None and \
        vertex_array[5] == None and \
        vertex_array[6] == None and \
        vertex_array[7] != None:
        return [(
            e7(vertex_array[0]),
            e3(vertex_array[0]),
            e8(vertex_array[0])
            ),
            (
            e8(vertex_array[0]),
            e3(vertex_array[0]),
            e4(vertex_array[0])
        )]



#--------------------------------------------------------------------------------

def variant3(vertex_array):
    if vertex_array[0] != None and \
        vertex_array[1] == None and \
        vertex_array[2] != None and \
        vertex_array[3] == None and \
        vertex_array[4] == None and \
        vertex_array[5] == None and \
        vertex_array[6] == None and \
        vertex_array[7] == None:
        return [(
            e4(vertex_array[0]),
            e1(vertex_array[0]),
            e9(vertex_array[0])
            ),
            (
            e12(vertex_array[0]),
            e2(vertex_array[0]),
            e3(vertex_array[0])
        )]


    if vertex_array[0] == None and \
        vertex_array[1] != None and \
        vertex_array[2] == None and \
        vertex_array[3] != None and \
        vertex_array[4] == None and \
        vertex_array[5] == None and \
        vertex_array[6] == None and \
        vertex_array[7] == None:
        return [(
            e2(vertex_array[0]),
            e10(vertex_array[0]),
            e1(vertex_array[0])
            ),
            (
            e11(vertex_array[0]),
            e3(vertex_array[0]),
            e4(vertex_array[0])
        )]

    if vertex_array[0] == None and \
        vertex_array[1] == None and \
        vertex_array[2] != None and \
        vertex_array[3] == None and \
        vertex_array[4] == None and \
        vertex_array[5] != None and \
        vertex_array[6] == None and \
        vertex_array[7] == None:
        return [(
            e2(vertex_array[0]),
            e3(vertex_array[0]),
            e12(vertex_array[0])
            ),
            (
            e6(vertex_array[0]),
            e5(vertex_array[0]),
            e10(vertex_array[0])
        )]

    if vertex_array[0] == None and \
        vertex_array[1] != None and \
        vertex_array[2] == None and \
        vertex_array[3] == None and \
        vertex_array[4] == None and \
        vertex_array[5] == None and \
        vertex_array[6] != None and \
        vertex_array[7] == None:
        return [(
            e1(vertex_array[0]),
            e2(vertex_array[0]),
            e10(vertex_array[0])
            ),
            (
            e12(vertex_array[0]),
            e7(vertex_array[0]),
            e6(vertex_array[0])
        )]


    if vertex_array[0] == None and \
        vertex_array[1] == None and \
        vertex_array[2] == None and \
        vertex_array[3] == None and \
        vertex_array[4] == None and \
        vertex_array[5] != None and \
        vertex_array[6] == None and \
        vertex_array[7] != None:
        return [(
            e7(vertex_array[0]),
            e11(vertex_array[0]),
            e8(vertex_array[0])
            ),
            (
            e6(vertex_array[0]),
            e5(vertex_array[0]),
            e10(vertex_array[0])
        )]


    if vertex_array[0] == None and \
        vertex_array[1] == None and \
        vertex_array[2] == None and \
        vertex_array[3] == None and \
        vertex_array[4] != None and \
        vertex_array[5] == None and \
        vertex_array[6] != None and \
        vertex_array[7] == None:
        return [(
            e8(vertex_array[0]),
            e9(vertex_array[0]),
            e5(vertex_array[0])
            ),
            (
            e12(vertex_array[0]),
            e7(vertex_array[0]),
            e6(vertex_array[0])
        )]


    if vertex_array[0] == None and \
        vertex_array[1] == None and \
        vertex_array[2] == None and \
        vertex_array[3] != None and \
        vertex_array[4] != None and \
        vertex_array[5] == None and \
        vertex_array[6] == None and \
        vertex_array[7] == None:
        return [(
            e3(vertex_array[0]),
            e4(vertex_array[0]),
            e11(vertex_array[0])
            ),
            (
            e8(vertex_array[0]),
            e9(vertex_array[0]),
            e5(vertex_array[0])
        )]

    if vertex_array[0] != None and \
        vertex_array[1] == None and \
        vertex_array[2] == None and \
        vertex_array[3] == None and \
        vertex_array[4] == None and \
        vertex_array[5] == None and \
        vertex_array[6] == None and \
        vertex_array[7] != None:
        return [(
            e7(vertex_array[0]),
            e11(vertex_array[0]),
            e8(vertex_array[0])
            ),
            (
            e4(vertex_array[0]),
            e1(vertex_array[0]),
            e9(vertex_array[0])
        )]

    if vertex_array[0] == None and \
        vertex_array[1] != None and \
        vertex_array[2] == None and \
        vertex_array[3] == None and \
        vertex_array[4] != None and \
        vertex_array[5] == None and \
        vertex_array[6] == None and \
        vertex_array[7] == None:
        return [(
            e1(vertex_array[0]),
            e2(vertex_array[0]),
            e10(vertex_array[0])
            ),
            (
            e8(vertex_array[0]),
            e8(vertex_array[0]),
            e9(vertex_array[0])
        )]

    if vertex_array[0] != None and \
        vertex_array[1] == None and \
        vertex_array[2] == None and \
        vertex_array[3] == None and \
        vertex_array[4] == None and \
        vertex_array[5] != None and \
        vertex_array[6] == None and \
        vertex_array[7] == None:
        return [(
            e4(vertex_array[0]),
            e1(vertex_array[0]),
            e9(vertex_array[0])
            ),
            (
            e6(vertex_array[0]),
            e5(vertex_array[0]),
            e10(vertex_array[0])
        )]

    if vertex_array[0] == None and \
        vertex_array[1] == None and \
        vertex_array[2] == None and \
        vertex_array[3] != None and \
        vertex_array[4] == None and \
        vertex_array[5] == None and \
        vertex_array[6] != None and \
        vertex_array[7] == None:
        return [(
            e3(vertex_array[0]),
            e4(vertex_array[0]),
            e11(vertex_array[0])
            ),
            (
            e12(vertex_array[0]),
            e7(vertex_array[0]),
            e6(vertex_array[0])
        )]

    if vertex_array[0] == None and \
        vertex_array[1] == None and \
        vertex_array[2] != None and \
        vertex_array[3] == None and \
        vertex_array[4] == None and \
        vertex_array[5] == None and \
        vertex_array[6] == None and \
        vertex_array[7] != None:
        return [(
            e7(vertex_array[0]),
            e11(vertex_array[0]),
            e8(vertex_array[0])
            ),
            (
            e2(vertex_array[0]),
            e3(vertex_array[0]),
            e12(vertex_array[0])
        )]

#--------------------------------------------------------------------------------


def variant4(vertex_array):
    if vertex_array[0] != None and \
        vertex_array[1] == None and \
        vertex_array[2] == None and \
        vertex_array[3] == None and \
        vertex_array[4] == None and \
        vertex_array[5] == None and \
        vertex_array[6] != None and \
        vertex_array[7] == None:
        return [(
            e4(vertex_array[0]),
            e1(vertex_array[0]),
            e9(vertex_array[0])
            ),
            (
            e12(vertex_array[0]),
            e7(vertex_array[0]),
            e6(vertex_array[0])
        )]

    if vertex_array[0] == None and \
        vertex_array[1] != None and \
        vertex_array[2] == None and \
        vertex_array[3] == None and \
        vertex_array[4] == None and \
        vertex_array[5] == None and \
        vertex_array[6] == None and \
        vertex_array[7] != None:
        return [(
            e1(vertex_array[0]),
            e2(vertex_array[0]),
            e10(vertex_array[0])
            ),
            (
            e8(vertex_array[0]),
            e7(vertex_array[0]),
            e11(vertex_array[0])
        )]

    if vertex_array[0] == None and \
        vertex_array[1] == None and \
        vertex_array[2] == None and \
        vertex_array[3] != None and \
        vertex_array[4] == None and \
        vertex_array[5] != None and \
        vertex_array[6] == None and \
        vertex_array[7] == None:
        return [(
            e6(vertex_array[0]),
            e5(vertex_array[0]),
            e10(vertex_array[0])
            ),
            (
            e3(vertex_array[0]),
            e4(vertex_array[0]),
            e11(vertex_array[0])
        )]

    if vertex_array[0] == None and \
        vertex_array[1] == None and \
        vertex_array[2] != None and \
        vertex_array[3] == None and \
        vertex_array[4] != None and \
        vertex_array[5] == None and \
        vertex_array[6] == None and \
        vertex_array[7] == None:
        return [(
            e2(vertex_array[0]),
            e3(vertex_array[0]),
            e12(vertex_array[0])
            ),
            (
            e5(vertex_array[0]),
            e8(vertex_array[0]),
            e9(vertex_array[0])
        )]


def variant4(vertex_array):
    if vertex_array[0] == None and \
        vertex_array[1] != None and \
        vertex_array[2] == None and \
        vertex_array[3] == None and \
        vertex_array[4] != None and \
        vertex_array[5] != None and \
        vertex_array[6] == None and \
        vertex_array[7] == None:
        return [(
            e2(vertex_array[0]),
            e6(vertex_array[0]),
            e8(vertex_array[0])
            ),
            (
            e2(vertex_array[0]),
            e8(vertex_array[0]),
            e9(vertex_array[0])),
            (
            e1(vertex_array[0]),
            e2(vertex_array[0]),
            e9(vertex_array[0]))
        ]

    if vertex_array[0] != None and \
        vertex_array[1] != None and \
        vertex_array[2] == None and \
        vertex_array[3] == None and \
        vertex_array[4] != None and \
        vertex_array[5] == None and \
        vertex_array[6] == None and \
        vertex_array[7] == None:
        return [(
            e8(vertex_array[0]),
            e4(vertex_array[0]),
            e2(vertex_array[0])
            ),
            (
            e10(vertex_array[0]),
            e8(vertex_array[0]),
            e2(vertex_array[0])),
            (
            e5(vertex_array[0]),
            e8(vertex_array[0]),
            e10(vertex_array[0]))
        ]


    if vertex_array[0] == None and \
        vertex_array[1] == None and \
        vertex_array[2] != None and \
        vertex_array[3] != None and \
        vertex_array[4] == None and \
        vertex_array[5] == None and \
        vertex_array[6] == None and \
        vertex_array[7] != None:
        return [(
            e2(vertex_array[0]),
            e4(vertex_array[0]),
            e8(vertex_array[0])
            ),
            (
            e12(vertex_array[0]),
            e8(vertex_array[0]),
            e7(vertex_array[0])),
            (
            e2(vertex_array[0]),
            e8(vertex_array[0]),
            e12(vertex_array[0]))
        ]

    if vertex_array[0] == None and \
        vertex_array[1] == None and \
        vertex_array[2] != None and \
        vertex_array[3] == None and \
        vertex_array[4] == None and \
        vertex_array[5] == None and \
        vertex_array[6] != None and \
        vertex_array[7] != None:
        return [(
            e8(vertex_array[0]),
            e6(vertex_array[0]),
            e2(vertex_array[0])
            ),
            (
            e2(vertex_array[0]),
            e3(vertex_array[0]),
            e8(vertex_array[0])),
            (
            e11(vertex_array[0]),
            e8(vertex_array[0]),
            e3(vertex_array[0]))
        ]

    if vertex_array[0] != None and \
        vertex_array[1] != None and \
        vertex_array[2] == None and \
        vertex_array[3] != None and \
        vertex_array[4] == None and \
        vertex_array[5] == None and \
        vertex_array[6] == None and \
        vertex_array[7] == None:
        return [(
            e11(vertex_array[0]),
            e10(vertex_array[0]),
            e9(vertex_array[0])
            ),
            (
            e2(vertex_array[0]),
            e10(vertex_array[0]),
            e11(vertex_array[0])),
            (
            e11(vertex_array[0]),
            e3(vertex_array[0]),
            e2(vertex_array[0]))
        ]

    if vertex_array[0] != None and \
        vertex_array[1] != None and \
        vertex_array[2] != None and \
        vertex_array[3] == None and \
        vertex_array[4] == None and \
        vertex_array[5] == None and \
        vertex_array[6] == None and \
        vertex_array[7] == None:
        return [(
            e12(vertex_array[0]),
            e10(vertex_array[0]),
            e9(vertex_array[0])
            ),
            (
            e12(vertex_array[0]),
            e9(vertex_array[0]),
            e3(vertex_array[0])),
            (
            e9(vertex_array[0]),
            e4(vertex_array[0]),
            e3(vertex_array[0]))
        ]

    if vertex_array[0] != None and \
        vertex_array[1] != None and \
        vertex_array[2] != None and \
        vertex_array[3] == None and \
        vertex_array[4] == None and \
        vertex_array[5] == None and \
        vertex_array[6] == None and \
        vertex_array[7] == None:
        return [(
            e12(vertex_array[0]),
            e10(vertex_array[0]),
            e9(vertex_array[0])
            ),
            (
            e12(vertex_array[0]),
            e9(vertex_array[0]),
            e3(vertex_array[0])),
            (
            e9(vertex_array[0]),
            e4(vertex_array[0]),
            e3(vertex_array[0]))
        ]




#--------------------------------------------------------------------------------
#--------------------------------------------------------------------------------
#--------------------------------------------------------------------------------
#--------------------------------------------------------------------------------
#--------------------------------------------------------------------------------

def variant18():
    return {"01011110": variant18_1,
            "10101101": variant18_2,
            "11011010": variant18_3,
            "11100101": variant18_4,
            "01011011": variant18_5,
            "10110101": variant18_6,
            "01111010": variant18_7,
            "10100111": variant18_8
            }

def variant18_1(vertex0):
    return [(
            e3(vertex0),
            e4(vertex0),
            e11(vertex0)
            ),
            (
            e1(vertex0),
            e2(vertex0),
            e12(vertex0)),
            (
            e7(vertex0),
            e8(vertex0),
            e9(vertex0)),
            (
            e12(vertex0),
            e9(vertex0),
            e1(vertex0)),
            (
            e7(vertex0),
            e9(vertex0),
            e12(vertex0))
        ]

def variant18_2(vertex0):
    return [(
            e2(vertex0),
            e3(vertex0),
            e12(vertex0)
            ),
            (
            e11(vertex0),
            e4(vertex0),
            e1(vertex0)),
            (
            e6(vertex0),
            e7(vertex0),
            e10(vertex0)),
            (
            e11(vertex0),
            e10(vertex0),
            e7(vertex0)),
            (
            e1(vertex0),
            e10(vertex0),
            e11(vertex0))
        ]


def variant18_3(vertex0):
    return [(
            e12(vertex0),
            e7(vertex0),
            e6(vertex0)
            ),
            (
            e10(vertex0),
            e3(vertex0),
            e2(vertex0)),
            (
            e5(vertex0),
            e8(vertex0),
            e11(vertex0)),
            (
            e10(vertex0),
            e5(vertex0),
            e3(vertex0)),
            (
            e3(vertex0),
            e5(vertex0),
            e11(vertex0))
        ]


def variant18_4(vertex0):
    return [(
            e11(vertex0),
            e8(vertex0),
            e7(vertex0)
            ),
            (
            e9(vertex0),
            e4(vertex0),
            e3(vertex0)),
            (
            e12(vertex0),
            e6(vertex0),
            e5(vertex0)),
            (
            e5(vertex0),
            e9(vertex0),
            e12(vertex0)),
            (
            e12(vertex0),
            e9(vertex0),
            e3(vertex0))
        ]


def variant18_5(vertex0):
    return [(
            e1(vertex0),
            e2(vertex0),
            e10(vertex0)
            ),
            (
            e3(vertex0),
            e4(vertex0),
            e9(vertex0)),
            (
            e9(vertex0),
            e5(vertex0),
            e3(vertex0)),
            (
            e3(vertex0),
            e5(vertex0),
            e12(vertex0)),
            (
            e5(vertex0),
            e6(vertex0),
            e12(vertex0))
        ]


def variant18_6(vertex0):
    return [(
            e10(vertex0),
            e6(vertex0),
            e5(vertex0)
            ),
            (
            e12(vertex0),
            e2(vertex0),
            e1(vertex0)),
            (
            e9(vertex0),
            e8(vertex0),
            e7(vertex0)),
            (
            e9(vertex0),
            e7(vertex0),
            e1(vertex0)),
            (
            e1(vertex0),
            e7(vertex0),
            e12(vertex0))
        ]


def variant18_7(vertex0):
    return [(
            e5(vertex0),
            e8(vertex0),
            e9(vertex0)
            ),
            (
            e10(vertex0),
            e7(vertex0),
            e6(vertex0)),
            (
            e7(vertex0),
            e10(vertex0),
            e11(vertex0)),
            (
            e11(vertex0),
            e10(vertex0),
            e1(vertex0)),
            (
            e1(vertex0),
            e4(vertex0),
            e11(vertex0))
        ]


def variant18_8(vertex0):
    return [(
            e9(vertex0),
            e4(vertex0),
            e1(vertex0)
            ),
            (
            e10(vertex0),
            e2(vertex0),
            e3(vertex0)),
            (
            e11(vertex0),
            e8(vertex0),
            e5(vertex0)),
            (
            e5(vertex0),
            e10(vertex0),
            e11(vertex0)),
            (
            e11(vertex0),
            e10(vertex0),
            e3(vertex0))
        ]

#--------------------------------------------------------------------------------
#--------------------------------------------------------------------------------
#--------------------------------------------------------------------------------
#--------------------------------------------------------------------------------
#--------------------------------------------------------------------------------

def variant1():
    return {"10000000": variant1_1,
            "01000000": variant1_2,
            "00100000": variant1_3,
            "00010000": variant1_4,
            "00001000": variant1_5,
            "00000100": variant1_6,
            "00000010": variant1_7,
            "00000001": variant1_8}


def variant1_1(vertex0):
    return [(
            e1(vertex0),
            e4(vertex0),
            e9(vertex0)
            )]

def variant1_2(vertex0):
    return [(
            e10(vertex0),
            e2(vertex0),
            e1(vertex0)
            )]

def variant1_3(vertex0):
    return [(
            e12(vertex0),
            e3(vertex0),
            e2(vertex0)
            )]

def variant1_4(vertex0):
    return [(
            e11(vertex0),
            e4(vertex0),
            e3(vertex0)
            )]

def variant1_5(vertex0):
    return [(
            e5(vertex0),
            e9(vertex0),
            e8(vertex0)
            )]

def variant1_6(vertex0):
    return [(
            e5(vertex0),
            e6(vertex0),
            e10(vertex0)
            )]

def variant1_7(vertex0):
    return [(
            e6(vertex0),
            e7(vertex0),
            e12(vertex0)
            )]

def variant1_8(vertex0):
    return [(
            e7(vertex0),
            e8(vertex0),
            e11(vertex0)
            )]







