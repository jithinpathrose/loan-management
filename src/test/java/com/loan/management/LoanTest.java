package com.loan.management;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class LoanTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @WithMockUser(username = "username", password = "password", roles = "USER")
    public void testGetLoanDetails() throws Exception {

        MvcResult result = mockMvc.perform(get("/loan-management/myLoanPlan").param("loanAmount", String.valueOf(30000.0)).
                        param("payBackDurationInYears", String.valueOf(2)).param("loanType", String.valueOf("housing_loan")).
                        contentType("application/json"))
                .andDo(print()).andExpect(status().isOk()).andReturn();
    }
}
