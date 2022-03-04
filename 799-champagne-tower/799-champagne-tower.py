class Solution:
    def champagneTower(self, poured: int, query_row: int, query_glass: int) -> float:
        rest = lambda glass: max(0, (glass-1)/2)
        row = [0, poured, 0]
        for i in range(query_row):
            row = [0] + [rest(row[j]) + rest(row[j+1]) for j in range(i+2)] + [0]
        return min(1, row[query_glass+1])