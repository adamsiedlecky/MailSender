package mailsender.db.emails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmailService {

    private EmailRepo emailRepo;

    @Autowired
    public EmailService(EmailRepo emailRepo) {
        this.emailRepo = emailRepo;
    }

    public List<Email> findAll() {
        return emailRepo.findAll();
    }

    public List<Email> findAll(Sort sort) {
        return emailRepo.findAll(sort);
    }

    public List<Email> findAllById(Iterable<Long> iterable) {
        return emailRepo.findAllById(iterable);
    }

    public <S extends Email> List<S> saveAll(Iterable<S> iterable) {
        return emailRepo.saveAll(iterable);
    }

    public void flush() {
        emailRepo.flush();
    }

    public <S extends Email> S saveAndFlush(S s) {
        return emailRepo.saveAndFlush(s);
    }

    public void deleteInBatch(Iterable<Email> iterable) {
        emailRepo.deleteInBatch(iterable);
    }

    public void deleteAllInBatch() {
        emailRepo.deleteAllInBatch();
    }

    public Email getOne(Long aLong) {
        return emailRepo.getOne(aLong);
    }

    public <S extends Email> List<S> findAll(Example<S> example) {
        return emailRepo.findAll(example);
    }

    public <S extends Email> List<S> findAll(Example<S> example, Sort sort) {
        return emailRepo.findAll(example, sort);
    }

    public Page<Email> findAll(Pageable pageable) {
        return emailRepo.findAll(pageable);
    }

    public <S extends Email> S save(S s) {
        return emailRepo.save(s);
    }

    public Optional<Email> findById(Long aLong) {
        return emailRepo.findById(aLong);
    }

    public boolean existsById(Long aLong) {
        return emailRepo.existsById(aLong);
    }

    public long count() {
        return emailRepo.count();
    }

    public void deleteById(Long aLong) {
        emailRepo.deleteById(aLong);
    }

    public void delete(Email email) {
        emailRepo.delete(email);
    }

    public void deleteAll(Iterable<? extends Email> iterable) {
        emailRepo.deleteAll(iterable);
    }

    public void deleteAll() {
        emailRepo.deleteAll();
    }

    public <S extends Email> Optional<S> findOne(Example<S> example) {
        return emailRepo.findOne(example);
    }

    public <S extends Email> Page<S> findAll(Example<S> example, Pageable pageable) {
        return emailRepo.findAll(example, pageable);
    }

    public <S extends Email> long count(Example<S> example) {
        return emailRepo.count(example);
    }

    public <S extends Email> boolean exists(Example<S> example) {
        return emailRepo.exists(example);
    }
}
