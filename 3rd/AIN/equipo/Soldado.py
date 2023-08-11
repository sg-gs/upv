import random
import json 
from pygomas.bditroop import BDITroop

def convert(l):
    return tuple(convert(x) for x in l) if type(l) is list else l

class BSoldado(BDITroop):

    def add_custom_actions(self, actions):
        super().add_custom_actions(actions)

        @actions.add_function(".determinar_posiciones", (tuple,tuple))
        def _determinar_posiciones(flag,soldiers):
            # de ASL a Python, se pasan listas y llegan como tuplas
            # y viceversa.  
            (x,y,z)=flag
            soldiers_list=list(soldiers)

            map_x=256
            map_z=256

            # map is x and z!
            distance_from_the_flag=50

            distance_from_left = x
            distance_from_right = abs(map_x - x)
            distance_from_top = abs(map_z - z)
            distance_from_bottom = z

            best_side_x = 'left' if distance_from_left >= distance_from_right else 'right'
            best_side_z = 'top' if distance_from_top >= distance_from_bottom else 'bottom'
            if distance_from_left == distance_from_right:
                best_side_x = random.choice(['left','right'])
            if distance_from_top == distance_from_bottom:
                best_side_z = random.choice(['top','bottom'])

            is_even = len(soldiers_list) % 2 == 0
            n_soldiers_sent_to_flag = 2 if is_even else 1

            print('Soldiers that are being sent to flag is/are %d', n_soldiers_sent_to_flag)

            soldiers_sent_to_flag = soldiers_list[:n_soldiers_sent_to_flag] 

            print('Soldier(s) sent to flag is/are:', soldiers_sent_to_flag)

            positions = []

            for soldier in soldiers_sent_to_flag:
                positions.append([soldier,x,y,z])

            n_soldiers = int(len(soldiers_list[n_soldiers_sent_to_flag:]) / 2)

            print('For the 2 positions, sending %d soldiers', n_soldiers)

            side_soldiers = soldiers_list[n_soldiers_sent_to_flag:(n_soldiers + n_soldiers_sent_to_flag)]

            height_soldiers = soldiers_list[n_soldiers + n_soldiers_sent_to_flag:]

            side_x=0
            side_z=z

            height_x=x
            height_z=0

            if best_side_x == 'left':
                side_x = x - distance_from_the_flag
            else:
                side_x = x + distance_from_the_flag
                
            print('side', best_side_x)

            if best_side_z == 'top':
                height_z = z + distance_from_the_flag
            else:
                height_z = z - distance_from_the_flag
                
            print('height', best_side_z)
            
            i=0
            for soldier in side_soldiers:
                if side_z > 126:
                    z = side_z - i
                else:
                    z = side_z + i
                positions.append([soldier,side_x,0,z])
                #print('Soldier ${1} goes to x: ${2}, z: ${3}', soldier, x, z)
                i += 15

            k=0
            for soldier in height_soldiers:
                if height_x > 126:
                    x = height_x - k
                else:
                    x = height_x + k
                
                positions.append([soldier,x,0,height_z])
                #print('Soldier ${1} goes to x: ${2}, z: ${3}', soldier, x, z)
                k += 15

            return convert(positions)
    


def left_bottom_corner_test():
    flag = [0,0,0]
    even_case = [
        ['soldado_1', 10,0,30],
        ['soldado_2', 10,0,30],
        ['soldado_3', 10,0,30],
        ['soldado_4', 10,0,30],
        ['soldado_5', 10,0,30],
        ['soldado_6', 10,0,30],
        ['soldado_7', 10,0,30],
        ['soldado_8', 10,0,30],
        
        
    ]
    
    odd_case = [
        ['soldado_1', 10,0,30],
        ['soldado_2', 10,0,30],
        ['soldado_3', 10,0,30],
        ['soldado_4', 10,0,30],
        ['soldado_5', 12,0,132],
        ['soldado_6', 155,0,27],
        ['soldado_7', 10,0,30]
    ]
    
    even_case_result = determinar_posiciones(flag, even_case)
    print('Even case', even_case_result)
    odd_case_result = determinar_posiciones(flag, odd_case)
    print('Odd case', odd_case_result)
def right_bottom_corner_test():
    flag = [256,0,0]
    even_case = [
        ['soldado_1', 10,0,30],
        ['soldado_2', 10,0,30],
        ['soldado_3', 10,0,30],
        ['soldado_4', 10,0,30],
        ['soldado_5', 10,0,30],
        ['soldado_6', 10,0,30],
        ['soldado_7', 10,0,30],
        ['soldado_8', 10,0,30],
        
        
    ]
    
    odd_case = [
        ['soldado_1', 10,0,30],
        ['soldado_2', 10,0,30],
        ['soldado_3', 10,0,30],
        ['soldado_4', 10,0,30],
        ['soldado_5', 12,0,132],
        ['soldado_6', 155,0,27],
        ['soldado_7', 10,0,30]
    ]
    
    even_case_result = determinar_posiciones(flag, even_case)
    print('Even case', even_case_result)
    print('#########################################################')
    odd_case_result = determinar_posiciones(flag, odd_case)
    print('Odd case', odd_case_result)
def left_top_corner_test():
    flag = [0,0,256]
    even_case = [
        ['soldado_1', 10,0,30],
        ['soldado_2', 10,0,30],
        ['soldado_3', 10,0,30],
        ['soldado_4', 10,0,30],
        ['soldado_5', 10,0,30],
        ['soldado_6', 10,0,30],
        ['soldado_7', 10,0,30],
        ['soldado_8', 10,0,30],
        
        
    ]
    
    odd_case = [
        ['soldado_1', 10,0,30],
        ['soldado_2', 10,0,30],
        ['soldado_3', 10,0,30],
        ['soldado_4', 10,0,30],
        ['soldado_5', 12,0,132],
        ['soldado_6', 155,0,27],
        ['soldado_7', 10,0,30]
    ]
    
    even_case_result = determinar_posiciones(flag, even_case)
    print('Even case', even_case_result)
    print('#########################################################')
    odd_case_result = determinar_posiciones(flag, odd_case)
    print('Odd case', odd_case_result)
def right_top_corner_test():
    flag = [256,0,256]
    even_case = [
        ['soldado_1', 10,0,30],
        ['soldado_2', 10,0,30],
        ['soldado_3', 10,0,30],
        ['soldado_4', 10,0,30],
        ['soldado_5', 10,0,30],
        ['soldado_6', 10,0,30],
        ['soldado_7', 10,0,30],
        ['soldado_8', 10,0,30],
        
        
    ]
    
    odd_case = [
        ['soldado_1', 10,0,30],
        ['soldado_2', 10,0,30],
        ['soldado_3', 10,0,30],
        ['soldado_4', 10,0,30],
        ['soldado_5', 12,0,132],
        ['soldado_6', 155,0,27],
        ['soldado_7', 10,0,30]
    ]
    
    even_case_result = determinar_posiciones(flag, even_case)
    print('Even case', even_case_result)
    print('#########################################################')
    odd_case_result = determinar_posiciones(flag, odd_case)
    print('Odd case', odd_case_result)
def center_test():
    flag = [128,0,128]
    even_case = [
        ['soldado_1', 10,0,30],
        ['soldado_2', 10,0,30],
        ['soldado_3', 10,0,30],
        ['soldado_4', 10,0,30],
        ['soldado_5', 10,0,30],
        ['soldado_6', 10,0,30],
        ['soldado_7', 10,0,30],
        ['soldado_8', 10,0,30],
        
        
    ]
    
    odd_case = [
        ['soldado_1', 10,0,30],
        ['soldado_2', 10,0,30],
        ['soldado_3', 10,0,30],
        ['soldado_4', 10,0,30],
        ['soldado_5', 12,0,132],
        ['soldado_6', 155,0,27],
        ['soldado_7', 10,0,30]
    ]
    
    even_case_result = determinar_posiciones(flag, even_case)
    print('Even case', even_case_result)
    print('#########################################################')
    odd_case_result = determinar_posiciones(flag, odd_case)
    print('Odd case', odd_case_result)
    
    center_test()    
