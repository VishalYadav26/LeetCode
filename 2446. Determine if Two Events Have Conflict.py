# Easy
# You are given two arrays of strings that represent two inclusive events that happened on the same day, 
# event1 and event2, 
# where:

# event1 = [startTime1, endTime1] and
# event2 = [startTime2, endTime2].

# Event times are valid 24 hours format in the form of HH:MM.

# A conflict happens when two events have some non-empty intersection (i.e., some moment is common to both events).

# Return true if there is a conflict between two events. 
# Otherwise, 
# return false.

# Example 1:
# Input: event1 = ["01:15","02:00"], event2 = ["02:00","03:00"]
# Output: true
  
# Explanation: 
# The two events intersect at time 2:00.
  
# Example 2:
# Input: event1 = ["01:00","02:00"], event2 = ["01:20","03:00"]
# Output: true
  
# Explanation: 
# The two events intersect starting from 01:20 to 02:00.
    
# Example 3:
# Input: event1 = ["10:00","11:00"], event2 = ["14:00","15:00"]
# Output: false
  
# Explanation: 
# The two events do not intersect.
 
# Constraints:
# evnet1.length == event2.length == 2.
# event1[i].length == event2[i].length == 5
# startTime1 <= endTime1
# startTime2 <= endTime2
# All the event times follow the HH:MM format.
  
# Solution
class Solution:
    def haveConflict(self, event1: List[str], event2: List[str]) -> bool:
        e1s = event1[0].split(":")
        e1e = event1[1].split(":")
        e2s = event2[0].split(":")
        e2e = event2[1].split(":")
        
        e1si = int(e1s[0]) * 60 + int(e1s[1])
        e1ei = int(e1e[0]) * 60 + int(e1e[1])
        e2si = int(e2s[0]) * 60 + int(e2s[1])
        e2ei = int(e2e[0]) * 60 + int(e2e[1])
        
        if e1ei < e2si or e2ei < e1si:
            return False
        else:
            return True
