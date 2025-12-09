import Data.Time.Clock -- módulo moderno de tiempo

mul a b = if (a==0) then 0
          else b + mul (a-1) b

mul5 b = 5 * b

retardoGeneral n = if (n == 0) then 0
                   else mul 5 123 + retardoGeneral (n-1)

retardoEspecial n = if (n == 0) then 0
                    else mul5 123 + retardoEspecial (n-1)

main = do
    -- Mide tiempo función general
    putStrLn "-----Funcion General-------"
    time1 <- getCurrentTime
    print (retardoGeneral 1000000)
    time2 <- getCurrentTime
    print (diffUTCTime time2 time1)
    
    -- Mide tiempo función especializada
    putStrLn "-------Funcion Especializada----------"
    time3 <- getCurrentTime
    print (retardoEspecial 1000000)
    time4 <- getCurrentTime
    print (diffUTCTime time4 time3)
    