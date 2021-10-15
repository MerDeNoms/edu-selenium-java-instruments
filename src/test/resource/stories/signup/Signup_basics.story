Narrative:
The story covers basic test of signup

Scenario: Type invalid year
Given: I open sign up page
When: I set month "Апрель"
And: I set day "20"
And: I set year "85"
And: I check share
Then: I see error "Укажите действительный год."
And: I do not see error "When were you born?"

Scenario: Type invalid email
Given: I open sign up page
When: I type email "test@mail.test"
And: I type confirmartion email "wrong@mail.test"
And: I type name "Testname"
And: I click signup
Then: I see error "Адреса электронной почты не совпадают."

Scenario: Empty password
Given: I open sign up page
When: I type email "test@mail.test"
And: I type confirmartion email "test@mail.test"
And: I type name "Testname"
And: I click signup
Then: I see error "Введите пароль."

Scenario: Invalid values
Given: I open sign up page
When: I type email "tesmail"
And: I type confirmartion email "wrong@mail.test"
And: I type name "Name"
And: I select sex "Мужчина"
And: I uncheck share
And: I click signup
Then: I see "7" errors
And: I see that error "4" has text "Укажите действительный день месяца."
