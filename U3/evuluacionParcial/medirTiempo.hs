import System.Time  --import Data.Time.LocalTime

retardoEsp n v= if (n==0) then 0
	         else ( retardoEsp (n-1) (pot15 7) )

mainEspecializado = do
	    time1 <- getClockTime 
	    putStrLn " ---- Tiempo de ejecucion formula especial de la funcion potencia------ "
	    print (retardoEsp 90000000 1)
	    time2 <- getClockTime
	    -- print  (timeDiffToString $ diffClockTimes time2 time1)
	    print  (diffClockTimes time2 time1) 
	    putStrLn " -------------------------------------------- "      

retardoGral n v= if (n==0) then 0
	         else (retardoGral (n-1) (pot 7 15)) 

mainGeneral = do
	    time1 <- getClockTime 
	    putStrLn " ---- Tiempo de ejecucion formula general de la funcion potencia------ "
	    print (retardoGral 90000000 1)
	    time2 <- getClockTime
	    print  (diffClockTimes time2 time1) 
	    putStrLn " --------------------------------------------- "

pot b e = if (e==0) then 1
	       else b * (pot b (e-1))

pot15 b =  b * b * b * b * b * b * b * b * b * b * b * b * b * b * b *  1







pot0 b = 1
pot5  b =  b * b * b * b * b *  1 
pot10 b =  b * b * b * b * b * b * b * b * b * b * 1 

pot20 b =  b * b * b * b * b * b * b * b * b * b * b * b * b * b * b *  b * b * b * b * b *  1




append    []  y    = y
append (x:xs) y = x : (append xs y)
 
append123 y= 1:(2:(3:(4:(5:y))))






