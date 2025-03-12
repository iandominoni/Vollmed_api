package med.voll.api.domain.consulta.validacoes.agendamento;

import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.domain.paciente.PacienteRepository;
import med.voll.api.infra.exception.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorPacienteAtivo implements ValidadorAgendamentoDeConsultas {
    @Autowired
    private PacienteRepository repository;
    public void validar(DadosAgendamentoConsulta dados){
        if(dados.idMedico() == null){
            return;

        }
        var pacienteEstaAtivo = repository.findAtivoById(dados.idMedico());
        if (!pacienteEstaAtivo){
            throw new ValidacaoException("Consulta nâo pode ser agendada com médico inativo");
        }
    }
}
