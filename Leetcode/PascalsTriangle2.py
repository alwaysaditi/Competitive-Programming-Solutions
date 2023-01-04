class PascalsTriangle2(object):



    def getRow(self, rowIndex):
        array =[1,1]
        newarray =[1]
        if rowIndex==0:

            return [1]
        elif rowIndex==1:
            return array
        else :
            for i in range(1,rowIndex):
                print('ouer')#outer loop for constructing each subarray
                for j in range((i)): #inner loop for constructing the elements
                    newarray.append(array[j]+array[j+1])
                newarray.append(1)
                print('newarray= ',newarray)
                array = newarray
                newarray = [1]
                print('array=',array)
        return array
