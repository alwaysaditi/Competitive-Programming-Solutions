# Logic of Code:
#
# Initially we sort the satisfaction array , and remove those elements which are lesser than 0. This is because all the
# positive elements will help the solution while the negative ones may or may not
# (0 will help because it will just push the positive numbers forward by one position, so we include that too)
# . The negative numbers are appended in an array called negatives.
# Then we take curval = sum of products in the satisfaction array and sumsat = sum of elements in the
# satisfaction array
# finally we sort the negatives array in the descending order and then for each element we ,
# check whether it helps the solution or not , updating curval and sumsat accordingly
# An important thing to note here is that , we start from the highest values of the negatives array ,
# since only if the i'th element is included , would it make sense to check for and
# include the (i+1)th element. As adding any element from negatives, would still cause
# the positive value to shift by the same amount , so it would make sense to start adding
# the lesser negative values first. Also if , for example , -1 and -8 are two elements in the array ,
# we cannot include -8 without including -1 as that would just cause the negative value to increase .
# Thus the values have to be added in the descending order from the negatives array into the overall
# solution
class ReducingDishes(object):
        def maxSatisfaction(self, satisfaction):
        satisfaction.sort()
        #remove all negative number initially .
        # then step by step for each negative number , see whether adding that negative number , causes a better shift in the value (such that the positives are increased) or a worse shift
        negatives = []
        print(satisfaction)
        i =0
        for i in range(0,len(satisfaction)):
        if satisfaction[0]>=0:
        break
        else:
        negatives.append(satisfaction.pop(0))


        print(satisfaction)
        sumsat = sum(satisfaction)
        if sumsat < 0:
        return 0
        curval = 0
        for j in range(0,len(satisfaction)):
        curval = curval + satisfaction[j]*(j+1)
        negatives.sort(reverse=True)
        print(negatives)
        maxval = curval
        for value in negatives:
        curval = value + curval +sumsat
        if curval > maxval:
        maxval = curval
        sumsat = sumsat+value
        else:
        break

        return(maxval)