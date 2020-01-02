package br.com.isl.alertasamu.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.isl.alertasamu.model.Alerta;
import br.com.isl.alertasamu.model.Atendimento;
//import br.com.isl.alertasamu.model.Atendimento;
import br.com.isl.alertasamu.model.UsuarioApp;
import br.com.isl.alertasamu.model.enums.StatusAlerta;
//import br.com.isl.alertasamu.model.enums.StatusAlerta;
import br.com.isl.alertasamu.repository.AlertaRepository;
import br.com.isl.alertasamu.repository.AtendimentoRepository;
//import br.com.isl.alertasamu.repository.AtendimentoRepository;
import br.com.isl.alertasamu.repository.UsuarioAppRepository;

@Service
public class BancoDeDadosService {

	@Autowired
	private AlertaRepository alertarepository;
	@Autowired
	private AtendimentoRepository atendimentorepository;
	@Autowired
	private UsuarioAppRepository usuarioapprepository;

	public void instanciaTestBancoDeDados() throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		UsuarioApp u1 = new UsuarioApp(null, "jonas", "jmd@gmail.com", "12234555", "masculino", "23232323-1212",
				"13232");
		UsuarioApp u2 = new UsuarioApp(null, "Oberdran", "obdsantos@gmail.com", "324323847", "Masculino", "984345678",
				"1965dbgc");

		Alerta ale1 = new Alerta(null, sdf.parse("01/11/2019 12:30"), -2122544, 4567533, "queda de moto", null, u1);
		Alerta ale2 = new Alerta(null, sdf.parse("02/11/2019 16:30"), -2564478, 3245557, "batida de carro", null, u2);
		Alerta ale3 = new Alerta(null, sdf.parse("02/11/2019 08:30"), -342544, 4567533, "atropelamento", null, u1);
		Alerta ale4 = new Alerta(null, sdf.parse("03/11/2019 14:30"), -2564478, 4207557, "vítima de assalto", null, u1);

		u1.getAlerta().addAll(Arrays.asList(ale1, ale3, ale4));
		u2.getAlerta().addAll(Arrays.asList(ale2));

		Atendimento A1 = new Atendimento(null, "visualizado e sem obs", StatusAlerta.FINALIZADO, ale1);
		ale1.setAtendimento(A1);
		Atendimento A2 = new Atendimento(null, "visualizado e verificado mais de uma pessoa acidentada",
				StatusAlerta.PENDENTE, ale2);
		ale2.setAtendimento(A2);

		Atendimento A3 = new Atendimento(null, "visualizado e verificado mais de uma pessoa acidentada",
				StatusAlerta.ABERTO, ale3);
		ale3.setAtendimento(A3);

		Atendimento A4 = new Atendimento(null, "visualizado e verificado mais de uma pessoa acidentada",
				StatusAlerta.ABERTO, ale4);
		ale4.setAtendimento(A4);

		usuarioapprepository.saveAll(Arrays.asList(u1, u2));
		alertarepository.saveAll(Arrays.asList(ale1, ale2, ale3, ale4));
		atendimentorepository.saveAll(Arrays.asList(A1, A2, A3, A4));

	}
}
