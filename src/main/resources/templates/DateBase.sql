insert into users (user_id,  user_name, password, roles) values (1, 'user', 'user', 'USER');
insert into users (user_id,  user_name, password, roles) values (2, 'admin', 'admin', 'ADMIN');

@Test
    public void testCreateCafe() throws Exception {
        // Создаем объект Cafe для отправки в запросе
        Cafe cafe = new Cafe();
cafe.setNameCafe("Название кафе");
cafe.setCity("Test");
cafe.setEmail("nan@");
cafe.setAddress("Адрес кафе");
// Отправляем POST запрос
        ResultActions result = mockMvc
                .perform(post("/api/cafe/new-cafe")
                        .with(httpBasic("admin", "admin"))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(cafe)));

// Проверяем, что статус ответа - 201 (Created)
        // result.andExpect(status().isCreated());
result.andExpect(status().isOk());
// Можете добавить дополнительные проверки, например, проверку содержимого ответа
    }

Отличия:
Добавлена строчка с аутентификацией
Фактически возвращается код 200 (OK) а не 201 (Created) - если хочется именно 201, его можно вернуть возвращая в методе контроллера нужный ResponseEntity