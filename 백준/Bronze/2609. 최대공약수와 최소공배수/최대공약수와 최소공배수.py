import sys
import math
input = sys.stdin.readline

A, B = map(int, input().rstrip().split())

result1 = math.gcd(A,B)
result2 = math.lcm(A,B)


print(result1)
print(result2)
