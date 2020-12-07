module Queue where

data Queue a = Queue [a] [a]

empty = Queue [] []

enqueue y (Queue xs ys) = Queue xs (y : ys)

dequeue (Queue (_ : xs) ys) = Queue xs ys
dequeue (Queue [] ys) = dequeue (Queue (reverse ys) [])

first (Queue (x : _) _) = x
first (Queue [] ys) = head (reverse ys)

isEmpty (Queue [] []) = True
isEmpty _ = False

size (Queue a b) = length a + length b

instance (Show a) => Show (Queue a) where
  show (Queue [] []) = " <- "
  show (Queue [] (y : ys)) = show ys ++ " <- " ++ show y
  show (Queue (x : xs) ys) = show x ++ " <-- " ++ show (Queue xs ys)

-- Other approach
-- module Queue (Queue, empty, enqueue, dequeue, first, isEmpty, size) where

-- data Queue a = EmptyQueue | Item a (Queue a) deriving (Show)

-- empty = EmptyQueue

-- enqueue x EmptyQueue = Item x EmptyQueue
-- enqueue x (Item a q) = Item a (enqueue x q)

-- dequeue (Item _ q) = q

-- first (Item a _) = a

-- isEmpty EmptyQueue = True
-- isEmpty _ = False

-- size EmptyQueue = 0
-- size (Item _ q) = 1 + size q