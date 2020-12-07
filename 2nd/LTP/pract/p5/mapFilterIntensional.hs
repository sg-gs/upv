module MapFilterIntensional where
    map' :: (Int -> Int) -> [Int] -> [Int]
    map' _ [] = []
    map' fn (y:ys) = fn y : map' fn ys

    filter' :: (Int -> Bool) -> [Int] -> [Int]
    filter' _ [] = []
    filter' fn (y:ys) 
        | fn y = y : filter' fn ys
        | otherwise = filter' fn ys
