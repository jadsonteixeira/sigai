INSERT INTO imoveis (endereco, valor_aluguel, descricao)
VALUES
('Rua João Pessoa, 78, Centro, Nova Cruz - RN', 800.00, 'Kitnet mobiliada'),
('Rua Assis Chateaubriand, 120, Centro, Nova Cruz - RN', 1200.00, 'Casa com 2 quartos e garagem'),
('Rua Industrial José de Brito, 45, Nova Cruz - RN', 650.00, 'Casa simples com 1 quarto'),
('Rua Getúlio Vargas, 210, Centro, Nova Cruz - RN', 1500.00, 'Casa ampla com 3 quartos e quintal'),
('Rua Professor Zuza, 95, Nova Cruz - RN', 950.00, 'Apartamento com 2 quartos e varanda');

INSERT INTO fotos (imovel_id, url, legenda, principal)
VALUES
(1, 'https://exemplo.com/fotos/imovel1-frente.jpg', 'Fachada do imóvel', TRUE),
(1, 'https://exemplo.com/fotos/imovel1-sala.jpg', 'Sala do imóvel', FALSE),

(2, 'https://exemplo.com/fotos/imovel2-frente.jpg', 'Fachada da casa', TRUE),
(2, 'https://exemplo.com/fotos/imovel2-quarto.jpg', 'Quarto principal', FALSE),

(3, 'https://exemplo.com/fotos/imovel3-frente.jpg', 'Entrada da casa', TRUE),
(3, 'https://exemplo.com/fotos/imovel3-cozinha.jpg', 'Cozinha do imóvel', FALSE),

(4, 'https://exemplo.com/fotos/imovel4-frente.jpg', 'Fachada da casa', TRUE),
(4, 'https://exemplo.com/fotos/imovel4-quintal.jpg', 'Quintal do imóvel', FALSE),

(5, 'https://exemplo.com/fotos/imovel5-frente.jpg', 'Fachada do apartamento', TRUE),
(5, 'https://exemplo.com/fotos/imovel5-varanda.jpg', 'Varanda do apartamento', FALSE);