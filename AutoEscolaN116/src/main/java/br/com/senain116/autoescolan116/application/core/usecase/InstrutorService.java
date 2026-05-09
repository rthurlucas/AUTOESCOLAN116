package br.com.senain116.autoescolan116.application.core.usecase;

import br.com.senain116.autoescolan116.adapter.in.controller.mapper.EnderecoMapper;
import br.com.senain116.autoescolan116.adapter.in.controller.mapper.InstrutorMapper;
import br.com.senain116.autoescolan116.adapter.in.controller.request.instrutor.DadosAtualizacaoInstrutor;
import br.com.senain116.autoescolan116.adapter.in.controller.request.instrutor.DadosCadastroInstrutor;
import br.com.senain116.autoescolan116.adapter.in.controller.response.instrutor.DadosDetalhamentoInstrutor;
import br.com.senain116.autoescolan116.application.core.domain.model.Instrutor;
import br.com.senain116.autoescolan116.application.port.out.InstrutorRepository;
import br.com.senain116.autoescolan116.exception.type.instrutor.InstrutorNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class InstrutorService {
    private final InstrutorRepository repository;
    private final InstrutorMapper mapper;
    private final EnderecoMapper enderecoMapper;

    public InstrutorService(InstrutorRepository repository,InstrutorMapper mapper, EnderecoMapper enderecoMapper){
        this.repository = repository;
        this.mapper = mapper;
        this.enderecoMapper = enderecoMapper;
    }

    @Transactional
    public DadosDetalhamentoInstrutor cadastrar(DadosCadastroInstrutor dados){
        Instrutor instrutor = mapper.toDomain(dados);
        Instrutor saved = repository.save(instrutor);
        return mapper.toDetailsDTO(saved);
    }

   public Page listar(Pageable paginacao){
        return repository
                .findAllByAtivoTrue(paginacao)
                .map(mapper::toListDTO);
   }

   public DadosDetalhamentoInstrutor detalhar(Long id){
        Instrutor instrutor = repository.findById(id)
                .orElseThrow(() -> new InstrutorNotFoundException("ID do instrutor nao encontrado: " + id));
        return mapper.toDetailsDTO(instrutor);
   }

   @Transactional
    public DadosDetalhamentoInstrutor atualizar(DadosAtualizacaoInstrutor dados){
        Instrutor instrutor = repository.findById(dados.id())
                .orElseThrow(() -> new InstrutorNotFoundException("ID do instrutor nao encontrado: " + dados.id()));
        instrutor.atualizarInformacoes(
                dados.nome(),
                dados.email(),
                dados.telefone(),
                dados.especialidade(),
                enderecoMapper.toDomain(dados.endereco())
        );
        Instrutor saved = repository.save(instrutor);
        return mapper.toDetailsDTO(saved);
   }

   @Transactional
   public void excluir(Long id){
        Instrutor instrutor = repository.findById(id)
                .orElseThrow(() -> new InstrutorNotFoundException("ID do instrutor nao encontrado: " + id));
        instrutor.excluir();
        Instrutor saved = repository.save(instrutor);
        repository.save(saved);
   }
}
