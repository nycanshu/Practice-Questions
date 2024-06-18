#User function Template for python3

class Solution:
    def maxVolume(self, perimeter, area):
        part1 = perimeter - math.sqrt(perimeter**2 - (24 * area))
        term = (part1 / 12)**2
        height = (perimeter / 4) - (2 * (part1 / 12))
        ans = term * height
        # Returning the maximum volume
        return ans

#{ 
 # Driver Code Starts
#Initial Template for Python 3
import math
if __name__ == '__main__':
    t = int(input())
    for _ in range(t):
        perimeter, area = [int(x) for x in input().split()]

        ob = Solution()
        print('%.2f' % ob.maxVolume(perimeter, area))

# } Driver Code Ends