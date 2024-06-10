CREATE DATABASE biblioteca_livros_web;

USE biblioteca_livros_web;

CREATE TABLE IF NOT EXISTS livro (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    autor VARCHAR(255) NOT NULL,
    texto LONGTEXT NOT NULL
);

INSERT INTO livro (titulo, autor, texto) VALUES
('Dom Quixote', 'Miguel de Cervantes', 'Em um lugar da Mancha, de cujo nome não quero lembrar-me...'),
('Guerra e Paz', 'Liev Tolstói', 'Tudo estava em confusão na casa dos Bolkonski...'),
('Cem Anos de Solidão', 'Gabriel García Márquez', 'Muitos anos depois, diante do pelotão de fuzilamento...'),
('Moby Dick', 'Herman Melville', 'Chamem-me Ishmael. Há alguns anos - nunca importa quantos exatamente...'),
('O Senhor dos Anéis', 'J.R.R. Tolkien', 'Numa toca no chão vivia um hobbit. Não uma toca desagradável, suja e molhada...'),
('1984', 'George Orwell', 'Era um dia frio e claro de abril, e os relógios batiam treze horas...'),
('A Revolução dos Bichos', 'George Orwell', 'Todas as noites, depois que Jones já estava roncando, havia reuniões secretas...'),
('A Odisséia', 'Homero', 'Canta, ó deusa, a ira de Aquiles, filho de Peleu, a destruição...'),
('Ulisses', 'James Joyce', 'Stately, plump Buck Mulligan came from the stairhead, bearing a bowl of lather on which a mirror and a razor lay crossed...'),
('A Divina Comédia', 'Dante Alighieri', 'No meio do caminho da nossa vida, eu me vi por uma selva escura, que a reta via era perdida...');



