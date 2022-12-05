package com.LT.restDummy.stub.service;

import com.LT.restDummy.date.module.DateModule;
import com.LT.restDummy.helper.DummyHelper;

public class GetCreditCardInfoAsync {
//    static public String getResponse(JSONObject jsonObject){
//        String request = jsonObject.toString().toLowerCase(Locale.ROOT);
//        String rqUID = StringUtils.substringBetween(request, "\"rquid\":\"", "\"");
//        String operUID = StringUtils.substringBetween(request, "\"operuid\":\"", "\"");
//        String cardNum = StringUtils.substringBetween(request, "\"cardnum\":\"", "\"");
//
//        return   "<GetCreditCardInfoAsyncRs>\n" +
//                "    <RqUID>"+rqUID+"</RqUID>\n" +
//                "    <RqTm>"+ DateModule.get_date_now()+"</RqTm>\n" +
//                "    <OperUID>"+operUID+"</OperUID>\n" +
//                "    <SPName>urn:sbrfsystems:99-pprbpci:tw</SPName>\n" +
//                "    <SystemId>urn:sbrfsystems:99-ufs-fl</SystemId>\n" +
//                "    <Status>\n" +
//                "        <StatusCode>0</StatusCode>\n" +
//                "        <StatusDesc>Успешная обработка операции</StatusDesc>\n" +
//                "    </Status>\n" +
//                "    <CardAcctRec>\n" +
//                "        <CardAcctId>\n" +
//                "            <CardNum>"+cardNum+"</CardNum>\n" +
//                "            <PmtDt>2021-09-29</PmtDt>\n" +
//                "            <CustInfo>\n" +
//                "                <PersonName>\n" +
//                "                    <ShortName>СЕРЫЙ М.В.</ShortName>\n" +
//                "                </PersonName>\n" +
//                "            </CustInfo>\n" +
//                "            <Contract>\n" +
//                "                <ContractNumber>0268-P-9307214850</ContractNumber>\n" +
//                "                <OpenDate>2021-04-26</OpenDate>\n" +
//                "                <ContractStatus>ACTIVE-Действует</ContractStatus>\n" +
//                "                <BlockReasonContract>+-Активный договор</BlockReasonContract>\n" +
//                "            </Contract>\n" +
//                "            <CreditLimit>29000</CreditLimit>\n" +
//                "            <OVDAmount>0</OVDAmount>\n" +
//                "            <LastBillingDate>2022-09-30</LastBillingDate>\n" +
//                "            <LocalDate>2022-10-17</LocalDate>\n" +
//                "            <MandatoryPaymentPAN>0</MandatoryPaymentPAN>\n" +
//                "            <MandPaymOnReport>151.31</MandPaymOnReport>\n" +
//                "            <TotalOnReport>301.31</TotalOnReport>\n" +
//                "            <AcctCur>RUR</AcctCur>\n" +
//                "            <CardStatus>\n" +
//                "                <Status>+ - КАРТОЧКА ОТКРЫТА</Status>\n" +
//                "            </CardStatus>\n" +
//                "        </CardAcctId>\n" +
//                "        <AcctBal>\n" +
//                "            <BalType>Avail</BalType>\n" +
//                "            <CurAmt>28850</CurAmt>\n" +
//                "        </AcctBal>\n" +
//                "        <AcctBal>\n" +
//                "            <BalType>Debt</BalType>\n" +
//                "            <CurAmt>150</CurAmt>\n" +
//                "        </AcctBal>\n" +
//                "        <AcctBal>\n" +
//                "            <BalType>Total_Tomorrow</BalType>\n" +
//                "            <CurAmt>150</CurAmt>\n" +
//                "        </AcctBal>\n" +
//                "        <AcctBal>\n" +
//                "            <BalType>Total_DayAfterTomorrow</BalType>\n" +
//                "            <CurAmt>150</CurAmt>\n" +
//                "        </AcctBal>\n" +
//                "        <AcctBal>\n" +
//                "            <BalType>Blocked_Cache</BalType>\n" +
//                "            <CurAmt>0</CurAmt>\n" +
//                "        </AcctBal>\n" +
//                "        <AcctBal>\n" +
//                "            <BalType>Total_ReportToday</BalType>\n" +
//                "            <CurAmt>150</CurAmt>\n" +
//                "        </AcctBal>\n" +
//                "        <CreditCardTariffInfo>\n" +
//                "            <CredCardInterestRate>23.9</CredCardInterestRate>\n" +
//                "            <OVDInterestRate>36</OVDInterestRate>\n" +
//                "            <CardProductionFee>0</CardProductionFee>\n" +
//                "            <CardFeeYearly>0</CardFeeYearly>\n" +
//                "            <CashWithdrawalMinFee>390</CashWithdrawalMinFee>\n" +
//                "            <CashWithdrawalPerc>3</CashWithdrawalPerc>\n" +
//                "            <CashTransferMinFee>390</CashTransferMinFee>\n" +
//                "            <CashTransferPerc>3</CashTransferPerc>\n" +
//                "            <RetailLimit>300000</RetailLimit>\n" +
//                "            <GracePeriod>60</GracePeriod>\n" +
//                "        </CreditCardTariffInfo>\n" +
//                "        <ListOfTKPDebtInfo>\n" +
//                "            <TKPDebtInfo>\n" +
//                "                <PeriodNumber>1</PeriodNumber>\n" +
//                "                <StartDateTime>2022-09-01T00:00:00.000+03:00</StartDateTime>\n" +
//                "                <ReportDateTime>2022-09-30T00:00:00.000+03:00</ReportDateTime>\n" +
//                "                <EndPaymentDateTime>2022-11-10T00:00:00.000+03:00</EndPaymentDateTime>\n" +
//                "                <IsTotalStatusOnReport>false</IsTotalStatusOnReport>\n" +
//                "                <ResidualDebt>150.00</ResidualDebt>\n" +
//                "                <GracePeriodType>Работает не грейс</GracePeriodType>\n" +
//                "                <PeriodType>4</PeriodType>\n" +
//                "            </TKPDebtInfo>\n" +
//                "            <TKPDebtInfo>\n" +
//                "                <PeriodNumber>2</PeriodNumber>\n" +
//                "                <StartDateTime>2022-10-01T00:00:00.000+03:00</StartDateTime>\n" +
//                "                <ReportDateTime>2022-11-10T00:00:00.000+03:00</ReportDateTime>\n" +
//                "                <EndPaymentDateTime>2022-12-10T00:00:00.000+03:00</EndPaymentDateTime>\n" +
//                "                <IsTotalStatusOnReport>false</IsTotalStatusOnReport>\n" +
//                "                <ResidualDebt>0.00</ResidualDebt>\n" +
//                "                <GracePeriodType>Работает</GracePeriodType>\n" +
//                "                <PeriodType>2</PeriodType>\n" +
//                "            </TKPDebtInfo>\n" +
//                "            <TKPDebtInfo>\n" +
//                "                <PeriodNumber>3</PeriodNumber>\n" +
//                "                <PeriodType>-1</PeriodType>\n" +
//                "            </TKPDebtInfo>\n" +
//                "        </ListOfTKPDebtInfo>\n" +
//                "    </CardAcctRec>\n" +
//                "</GetCreditCardInfoAsyncRs>";
//    }

    static public String getResponse(String request, String type) {
//        String request = object.toString().toLowerCase(Locale.ROOT);
//        String rqUID = StringUtils.substringBetween(request, "\"rquid\":\"", "\"");
//        String operUID = StringUtils.substringBetween(request, "\"operuid\":\"", "\"");
//        String cardNum = StringUtils.substringBetween(request, "\"cardnum\":\"", "\"");
//
//        String rqUID = StringUtils.substringBetween(request, "rquid=",",");
//        String operUID = StringUtils.substringBetween(request, "operuid=", ",");
//        String cardNum = StringUtils.substringBetween(request, "cardnum=", ",");

        return   "<GetCreditCardInfoAsyncRs>\n" +
                "    <RqUID>"+ DummyHelper.parameterCorrelate(request, "RqUID", type) +"</RqUID>\n" +
                "    <RqTm>"+ DateModule.get_date_now()+"</RqTm>\n" +
                "    <OperUID>"+DummyHelper.parameterCorrelate(request, "OperUID", type)+"</OperUID>\n" +
                "    <SPName>urn:sbrfsystems:99-pprbpci:tw</SPName>\n" +
                "    <SystemId>urn:sbrfsystems:99-ufs-fl</SystemId>\n" +
                "    <Status>\n" +
                "        <StatusCode>0</StatusCode>\n" +
                "        <StatusDesc>Успешная обработка операции</StatusDesc>\n" +
                "    </Status>\n" +
                "    <CardAcctRec>\n" +
                "        <CardAcctId>\n" +
                "            <CardNum>"+DummyHelper.parameterCorrelate(request, "CardNum",  type)+"</CardNum>\n" +
                "            <PmtDt>2021-09-29</PmtDt>\n" +
                "            <CustInfo>\n" +
                "                <PersonName>\n" +
                "                    <ShortName>СЕРЫЙ М.В.</ShortName>\n" +
                "                </PersonName>\n" +
                "            </CustInfo>\n" +
                "            <Contract>\n" +
                "                <ContractNumber>0268-P-9307214850</ContractNumber>\n" +
                "                <OpenDate>2021-04-26</OpenDate>\n" +
                "                <ContractStatus>ACTIVE-Действует</ContractStatus>\n" +
                "                <BlockReasonContract>+-Активный договор</BlockReasonContract>\n" +
                "            </Contract>\n" +
                "            <CreditLimit>29000</CreditLimit>\n" +
                "            <OVDAmount>0</OVDAmount>\n" +
                "            <LastBillingDate>2022-09-30</LastBillingDate>\n" +
                "            <LocalDate>2022-10-17</LocalDate>\n" +
                "            <MandatoryPaymentPAN>0</MandatoryPaymentPAN>\n" +
                "            <MandPaymOnReport>151.31</MandPaymOnReport>\n" +
                "            <TotalOnReport>301.31</TotalOnReport>\n" +
                "            <AcctCur>RUR</AcctCur>\n" +
                "            <CardStatus>\n" +
                "                <Status>+ - КАРТОЧКА ОТКРЫТА</Status>\n" +
                "            </CardStatus>\n" +
                "        </CardAcctId>\n" +
                "        <AcctBal>\n" +
                "            <BalType>Avail</BalType>\n" +
                "            <CurAmt>28850</CurAmt>\n" +
                "        </AcctBal>\n" +
                "        <AcctBal>\n" +
                "            <BalType>Debt</BalType>\n" +
                "            <CurAmt>150</CurAmt>\n" +
                "        </AcctBal>\n" +
                "        <AcctBal>\n" +
                "            <BalType>Total_Tomorrow</BalType>\n" +
                "            <CurAmt>150</CurAmt>\n" +
                "        </AcctBal>\n" +
                "        <AcctBal>\n" +
                "            <BalType>Total_DayAfterTomorrow</BalType>\n" +
                "            <CurAmt>150</CurAmt>\n" +
                "        </AcctBal>\n" +
                "        <AcctBal>\n" +
                "            <BalType>Blocked_Cache</BalType>\n" +
                "            <CurAmt>0</CurAmt>\n" +
                "        </AcctBal>\n" +
                "        <AcctBal>\n" +
                "            <BalType>Total_ReportToday</BalType>\n" +
                "            <CurAmt>150</CurAmt>\n" +
                "        </AcctBal>\n" +
                "        <CreditCardTariffInfo>\n" +
                "            <CredCardInterestRate>23.9</CredCardInterestRate>\n" +
                "            <OVDInterestRate>36</OVDInterestRate>\n" +
                "            <CardProductionFee>0</CardProductionFee>\n" +
                "            <CardFeeYearly>0</CardFeeYearly>\n" +
                "            <CashWithdrawalMinFee>390</CashWithdrawalMinFee>\n" +
                "            <CashWithdrawalPerc>3</CashWithdrawalPerc>\n" +
                "            <CashTransferMinFee>390</CashTransferMinFee>\n" +
                "            <CashTransferPerc>3</CashTransferPerc>\n" +
                "            <RetailLimit>300000</RetailLimit>\n" +
                "            <GracePeriod>60</GracePeriod>\n" +
                "        </CreditCardTariffInfo>\n" +
                "        <ListOfTKPDebtInfo>\n" +
                "            <TKPDebtInfo>\n" +
                "                <PeriodNumber>1</PeriodNumber>\n" +
                "                <StartDateTime>2022-09-01T00:00:00.000+03:00</StartDateTime>\n" +
                "                <ReportDateTime>2022-09-30T00:00:00.000+03:00</ReportDateTime>\n" +
                "                <EndPaymentDateTime>2022-11-10T00:00:00.000+03:00</EndPaymentDateTime>\n" +
                "                <IsTotalStatusOnReport>false</IsTotalStatusOnReport>\n" +
                "                <ResidualDebt>150.00</ResidualDebt>\n" +
                "                <GracePeriodType>Работает не грейс</GracePeriodType>\n" +
                "                <PeriodType>4</PeriodType>\n" +
                "            </TKPDebtInfo>\n" +
                "            <TKPDebtInfo>\n" +
                "                <PeriodNumber>2</PeriodNumber>\n" +
                "                <StartDateTime>2022-10-01T00:00:00.000+03:00</StartDateTime>\n" +
                "                <ReportDateTime>2022-11-10T00:00:00.000+03:00</ReportDateTime>\n" +
                "                <EndPaymentDateTime>2022-12-10T00:00:00.000+03:00</EndPaymentDateTime>\n" +
                "                <IsTotalStatusOnReport>false</IsTotalStatusOnReport>\n" +
                "                <ResidualDebt>0.00</ResidualDebt>\n" +
                "                <GracePeriodType>Работает</GracePeriodType>\n" +
                "                <PeriodType>2</PeriodType>\n" +
                "            </TKPDebtInfo>\n" +
                "            <TKPDebtInfo>\n" +
                "                <PeriodNumber>3</PeriodNumber>\n" +
                "                <PeriodType>-1</PeriodType>\n" +
                "            </TKPDebtInfo>\n" +
                "        </ListOfTKPDebtInfo>\n" +
                "    </CardAcctRec>\n" +
                "</GetCreditCardInfoAsyncRs>";
    }
    }
