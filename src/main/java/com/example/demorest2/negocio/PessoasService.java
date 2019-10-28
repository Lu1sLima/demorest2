package com.example.demorest2.negocio;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demorest2.entidades.Pessoa;
import com.example.demorest2.repositorios.PessoaRepository;
import com.example.demorest2.webservices.PessoaDTO;


//Controlador consome o services E CONTROLADOR NAO TERÁ DEPENDÊNCIA PARA REPOSITÓRIO
@Service
public class PessoasService {
	private PessoaRepository pessoas;
	
	@Autowired 
	public PessoasService(PessoaRepository pessoas) {
		this.pessoas = pessoas;
	}
	
	@Transactional(readOnly = true)
	public List<PessoaDTO> listarPessoas(){
		try {
			List<Pessoa> listaPessoas = pessoas.findAll();
			List<PessoaDTO> listaDTO = new ArrayList<>();
			for(Pessoa p : listaPessoas) {
				PessoaDTO dto = new PessoaDTO();
				dto.setId(p.getId());
				dto.setNome(p.getNome());
				dto.setIdoso(p.getIdade()>=65);
				listaDTO.add(dto);
			}
			return listaDTO;
		}
		catch(Exception e){
			throw new PessoasServiceException("Falha de consulta!");
		}
	}
}
