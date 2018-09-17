package sparkteste;

import java.sql.Date;
import java.time.Instant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyService {

    private static final Logger logger = LoggerFactory.getLogger(MyService.class);

    @Autowired
    private BookRepository bookRepository;

    public void run() {
        logger.info(".... Fetching books");

        logger.info(Date.from(Instant.now()).toString() + "isbn111-1234 -->" + bookRepository.getByIsbn(new Book("isbn-1234", "teste")));
        logger.info(Date.from(Instant.now()).toString() + "isbn-4567 -->" + bookRepository.getByIsbn(new Book("isbn-4567", "teste")));
        logger.info(Date.from(Instant.now()).toString() + "isbn-1234 -->" + bookRepository.getByIsbn(new Book("isbn-1234", "teste")));
        logger.info(Date.from(Instant.now()).toString() + "isbn-4567 -->" + bookRepository.getByIsbn(new Book("isbn-4567", "teste")));
        logger.info(Date.from(Instant.now()).toString() + "isbn-1234 -->" + bookRepository.getByIsbn(new Book("isbn-1234", "teste")));
        logger.info(Date.from(Instant.now()).toString() + "isbn-1234 -->" + bookRepository.getByIsbn(new Book("isbn-1234", "teste")));
    }

}
