module Member where
    member :: Int -> [Int] -> Bool
    member _ [] = False
    member x (y:ys) = if x == y then True
                      else member x ys

-- member x (y:ys) = x == y || member x ys