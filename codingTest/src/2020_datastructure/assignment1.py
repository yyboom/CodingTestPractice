# Name : 조윤영
# Student ID: secret
#
# Write a simple annotation in your code

'''
Problem1
'''
def counting_top_k_characters(data, k=None):
    ## CODE HERE ##
    
    small_data=data.lower() #data를 소문자로 변화.
    data_set=set(x for x in small_data if x not in '?\'\n -)(,') 
    data_list=list(data_set)

    cnt=list()

    print("Top",k,"alphabetic characters")

    for n in data_list:
        counting_characters=small_data.count(n)
        cnt.append([counting_characters,n])
        cnt.sort(reverse=True)

    for i in range(0,k):
        print(cnt[i][1],"-",cnt[i][0])

'''
Problem2
'''

import numpy as np
def matrix2d_multiplication(A, B):
    assert A.ndim == 2 and B.ndim == 2
    ## CODE HERE ##
    result=[]
    
    if len(A[0]) == len(B) and len(B[0]) == len(A):
        for i in range(len(A)):
            temp = []
            for k in range(len(B[0])):
                sum=0
                for j in range(len(B)):
                    sum += A[i][j]*B[j][k]
                temp.append(sum)
            result.append(temp)

        for t in range(len(result)):
            print(result[t],end="\n")

    else:
        print("Shape Error!")




'''
Problem3
'''
'''
class Fraction():
    def __init__(self, numerator, denominator):
        assert denominator != 0
        ## CODE HERE ##
    def gcd(self, x, y):
        ## CODE HERE ##
    ## CODE HERE ##
    '''


'''
Problem4
'''
'''
def histogram(grades_tuple, letter_grades, course=None):
    ## CODE HERE ##
'''
    