class BuySellStock2(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        total = 0
        bought = False
        sold = False
        if ((len(prices)==2) and (prices[0]<=prices[1])):
            return prices[1]-prices[0]

        for i in range(0,(len(prices)-1)):

            if ((bought==False)and (prices[i+1]>prices[i])):
                bought = True
                sold=False
                print('buying case a ',prices[i])
                total = total - prices[i]
                if (i==(len(prices)-2) and bought == True):
                    total= total+prices[i+1]
            elif((sold==False) and (bought==False) and (prices[i+1]<prices[i])):
                print('case b')
                continue
            elif ((sold==False)and (prices[i+1]<prices[i])):
                sold = True
                bought = False
                total = total+prices[i]
                print('selling case c  ',prices[i])

            elif((i+1)==(len(prices)-1) and sold==False):
                print('case d')
                total = total+prices[i+1]

            else:
                print('case e ')
                continue
        return total