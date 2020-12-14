type Side = Float

type Apothem = Float

type Radius = Float

data Pentagon = Pentagon Side Apothem

data Circle = Circle Radius

-- class Shape a where
class (Eq a, Show a) => Shape a where
  perimeter :: a -> Float
  area :: a -> Float

instance Shape Pentagon where
  perimeter (Pentagon s a) = 5 * s
  area (Pentagon s a) = (5 / 2) * s * a

instance Shape Circle where
  perimeter (Circle r) = 2 * pi * r
  area (Circle r) = r * r * pi

-- Define Show and Eq applied to concrete types
instance Show Pentagon where
  show (Pentagon s a) = "Pentagon, side:" ++ show s ++ ", apothem: " ++ show a

instance Show Circle where
  show (Circle r) = "Circle, radius:" ++ show r

-- Two diff ways of declaring equality
instance Eq Pentagon where
  Pentagon sx ax == Pentagon sy ay = sx == sy && ax == ay

instance Eq Circle where
  Circle rx == Circle ry
    | rx == ry = True
    | otherwise = False

--

type Height = Float

type Volume = Float

volumePrism :: (Shape a) => a -> Height -> Volume
volumePrism base height = (area base) * height

type Surface = Float

surfacePrism :: (Shape a) => a -> Height -> Surface
surfacePrism base height = 2 * (area base) + height * (perimeter base)