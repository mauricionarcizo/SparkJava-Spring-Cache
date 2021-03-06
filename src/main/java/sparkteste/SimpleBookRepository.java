package sparkteste;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class SimpleBookRepository implements BookRepository {

    @Override
    @Cacheable(value = "books")
    public Book getByIsbn(final Book isbn) {
        simulateSlowService();
        return new Book(isbn.getIsbn(), "Some book");
    }

    // Don't do this at home
    private void simulateSlowService() {
        try {
            final long time = 3000L;
            Thread.sleep(time);
        } catch (final InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}
