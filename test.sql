SELECT origen, destino, (ELT(WEEKDAY(sist_reserva_db.vuelo.fecha) + 1, 'Lunes', 'Martes', 'Miercoles', 'Jueves', 'Viernes', 'Sábado', 'Domingo')) AS DIA_SEMANA, fecha AS FECHA_VUELO, hora AS HORA_SALIDA
FROM sist_reserva_db.vuelo

SELECT * FROM sist_reserva_db.costodiajornada WHERE dia ='Miercoles' AND hora;

SELECT origen, destino, 
(ELT(WEEKDAY(sist_reserva_db.vuelo.fecha) + 1, 
'Lunes', 'Martes', 'Miercoles', 'Jueves', 'Viernes', 'Sábado', 'Domingo')) AS DIA_SEMANA_SALIDA,
fecha AS FECHA_VUELO, 
hora AS HORA_SALIDA,
jornada,
costo
FROM vuelo, costodiajornada;

select dia, Time_Format(hora_inicio_jornada,'%r'), Time_Format(hora_fin_jornada,'%r'), jornada, costo 
from costodiajornada ;

SELECT origen, destino, 
(ELT(WEEKDAY(sist_reserva_db.vuelo.fecha) + 1, 
'Lunes', 'Martes', 'Miercoles', 'Jueves', 'Viernes', 'Sábado', 'Domingo')) AS DIA_SEMANA_SALIDA,
fecha AS FECHA_VUELO, 
hora AS HORA_SALIDA,
jornada,
costo
FROM vuelo, costodiajornada;

select dia, Time_Format(hora_inicio_jornada,'%r'), Time_Format(hora_fin_jornada,'%r'), jornada, costo 
from costodiajornada ;

SELECT origen, destino, 
(ELT(WEEKDAY(sist_reserva_db.vuelo.fecha) + 1, 
'Lunes', 'Martes', 'Miercoles', 'Jueves', 'Viernes', 'Sábado', 'Domingo')) AS DIA_SEMANA_SALIDA,
fecha AS FECHA_VUELO, 
hora AS HORA_SALIDA,
jornada,
costo
FROM vuelo, costodiajornada;

select dia, Time_Format(hora_inicio_jornada,'%r'), Time_Format(hora_fin_jornada,'%r'), jornada, costo 
from costodiajornada where dia = 'Miercoles' and hora_inicio_jornada <= '13:00:00' and hora_fin_jornada >= '13:00:00';

SELECT origen, destino, 
(ELT(WEEKDAY(sist_reserva_db.vuelo.fecha) + 1, 
'Lunes', 'Martes', 'Miercoles', 'Jueves', 'Viernes', 'Sábado', 'Domingo')) AS DIA_SEMANA_SALIDA,
fecha AS FECHA_VUELO, 
hora AS HORA_SALIDA,
(select costodiajornada.jornada from costodiajornada where costodiajornada.hora_inicio_jornada <= vuelo.hora and costodiajornada.hora_fin_jornada >= vuelo.hora and costodiajornada.dia = (ELT(WEEKDAY(sist_reserva_db.vuelo.fecha) + 1, 
'Lunes', 'Martes', 'Miercoles', 'Jueves', 'Viernes', 'Sábado', 'Domingo'))) as jornada,
costo
FROM vuelo, costodiajornada;

select dia, Time_Format(hora_inicio_jornada,'%r'), Time_Format(hora_fin_jornada,'%r'), jornada, costo 
from costodiajornada where dia = 'Miercoles' and hora_inicio_jornada <= '08:00:00' and hora_fin_jornada >= '08:00:00';

**********************************************************************************************************************************************************
SELECT distinct origen, destino, (ELT(WEEKDAY(sist_reserva_db.vuelo.fecha) + 1, 
'Lunes', 'Martes', 'Miercoles', 'Jueves', 'Viernes', 'Sábado', 'Domingo')) AS dia_salida, 
fecha,
Time_Format(hora,'%r') as hora_salida,
(select c.jornada from costodiajornada as c where c.dia = (ELT(WEEKDAY(sist_reserva_db.vuelo.fecha) + 1, 
'Lunes', 'Martes', 'Miercoles', 'Jueves', 'Viernes', 'Sábado', 'Domingo')) and hora_inicio_jornada <= vuelo.hora and hora_fin_jornada >= vuelo.hora) as jornada,
(select c.costo from costodiajornada as c where c.dia = (ELT(WEEKDAY(sist_reserva_db.vuelo.fecha) + 1, 
'Lunes', 'Martes', 'Miercoles', 'Jueves', 'Viernes', 'Sábado', 'Domingo')) and hora_inicio_jornada <= vuelo.hora and hora_fin_jornada >= vuelo.hora)  costo_viaje
FROM sist_reserva_db.vuelo, sist_reserva_db.costodiajornada;
