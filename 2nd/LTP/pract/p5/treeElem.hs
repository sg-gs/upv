module TreeElem where
    data BinTreeInt = Void | Node Int BinTreeInt BinTreeInt
    -- treeElem :: Int -> BinTreeInt -> Bool
    -- treeElem n Void = False
    -- treeElem e Node x left right
    --     | e == x = True
    --     | e < x = treeElem e left
    --     | otherwise = treeElem e right