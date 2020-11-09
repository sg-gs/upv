module DaysAmonth where
    daysAmonth :: Int -> Int -> Int 
    daysAmonth m a 
        | m == 2 && leapyear a = 29
        | m == 2 = 28
        | m == 4 || m == 6 || m == 9 || m == 11 = 30
        | otherwise = 31