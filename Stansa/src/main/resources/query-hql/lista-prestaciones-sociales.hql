select sp.fecha, sp.problematicaSocial,sp.resultado,asist.nombres ||' ' || asist.apellidoPaterno ||' '|| asist.apellidoMaterno from SocPrestacionAsistencial sp join sp.perfil pas join pas.persona asist join sp.servicioSocial ss join ss.perfil p join p.persona per where per.docIdentidad = '47180885'