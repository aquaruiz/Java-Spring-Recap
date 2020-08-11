package com.pluralsight.pension.withdrawal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.pluralsight.pension.Account;
import com.pluralsight.pension.setup.BackgroundCheckService;

@ExtendWith(MockitoExtension.class)
class AccountClosingServiceTest {

    @Mock
    private BackgroundCheckService backgroundCheckService;
    Instant fixedTime = LocalDate.of(2019, 7, 4)
            .atStartOfDay(ZoneId.systemDefault()).toInstant();
    Clock clock = Clock.fixed(fixedTime, ZoneId.systemDefault());
    private AccountClosingService underTest = new AccountClosingService(backgroundCheckService, clock);

    @Test
    public void shouldDeclineAccountClosingTodayIfHolderReachesRetirementTomorrow() throws IOException {
        Account account = new Account();
        account.setDob(LocalDate.of(1954, 7, 5));

        final AccountClosingResponse accountClosingResponse = underTest.closeAccount(account);
        
        assertEquals(AccountClosingStatus.CLOSING_DENIED, accountClosingResponse.getStatus());
        
        System.out.println(accountClosingResponse.getProcessingDate());
        
        assertEquals(LocalDateTime.ofInstant(fixedTime, ZoneOffset.systemDefault()),
                accountClosingResponse.getProcessingDate());
    }
}