package com.LT.restDummy.stub.service;

import com.LT.restDummy.date.module.DateModule;
import com.LT.restDummy.helper.DummyHelper;

public class GetCreditCardAnnuity {
    static public String getResponse(String request, String type) {

        return "{\n" +
                "\t\"header\": {\n" +
                "\t\t\"rqUID\": \"" + DummyHelper.parameterCorrelate(request, "rqUID", type) + "\",\n" +
                "\t\t\"rqTm\": \"" + DateModule.get_date_now() + "\",\n" +
                "\t\t\"spName\": \"urn:sbrfsystems:99-ufs-fl\",\n" +
                "\t\t\"systemId\": \"urn:sbrfsystems:99-pprb:tcp\"\n" +
                "\t},\n" +
                "\t\"status\": {\n" +
                "\t\t\"statusCode\": 0,\n" +
                "\t\t\"statusDesc\": \"Успех\"\n" +
                "\t},\n" +
                "\t\"contractInterestRate\": 23.9,\n" +
                "\t\"annuityQuantity\": 2,\n" +
                "\t\"annuities\": [\n" +
                "\t\t{\n" +
                "\t\t\t\"annuityId\": 3000000000000501,\n" +
                "\t\t\t\"annuityFullAmount\": 1000,\n" +
                "\t\t\t\"annuityInterestRate\": 23.9,\n" +
                "\t\t\t\"annuityResidualAmount\": 1000,\n" +
                "\t\t\t\"annuityCalculatedPaymentAmount\": 178.48,\n" +
                "\t\t\t\"annuityDate\": \"2022-11-15\",\n" +
                "\t\t\t\"annuityLastDate\": \"2023-11-30\",\n" +
                "\t\t\t\"annuityPaymentQuantity\": 7,\n" +
                "\t\t\t\"annuitySchedule\": [\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"annuityPeriodNumber\": 1,\n" +
                "\t\t\t\t\t\"annuityStartDate\": \"2022-12-01\",\n" +
                "\t\t\t\t\t\"annuityEndDate\": \"2022-12-31\",\n" +
                "\t\t\t\t\t\"annuityInAmount\": 1000,\n" +
                "\t\t\t\t\t\"annuityPaymentAmount\": 178.48,\n" +
                "\t\t\t\t\t\"annuityDueLoan\": 168.66,\n" +
                "\t\t\t\t\t\"annuityDueInterest\": 9.82,\n" +
                "\t\t\t\t\t\"annuityOverdueAmount\": 0,\n" +
                "\t\t\t\t\t\"annuityOverdueInterest\": 0,\n" +
                "\t\t\t\t\t\"annuityRepaidLoan\": 0,\n" +
                "\t\t\t\t\t\"annuityRepaidInterest\": 0,\n" +
                "\t\t\t\t\t\"annuityRepaidOverdueAmount\": 0,\n" +
                "\t\t\t\t\t\"annuityRepaidOverdueInterest\": 0,\n" +
                "\t\t\t\t\t\"annuityOutAmount\": 831.34\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"annuityPeriodNumber\": 2,\n" +
                "\t\t\t\t\t\"annuityStartDate\": \"2023-01-01\",\n" +
                "\t\t\t\t\t\"annuityEndDate\": \"2023-01-31\",\n" +
                "\t\t\t\t\t\"annuityInAmount\": 831.34,\n" +
                "\t\t\t\t\t\"annuityPaymentAmount\": 178.48,\n" +
                "\t\t\t\t\t\"annuityDueLoan\": 158.19,\n" +
                "\t\t\t\t\t\"annuityDueInterest\": 20.29,\n" +
                "\t\t\t\t\t\"annuityOverdueAmount\": 0,\n" +
                "\t\t\t\t\t\"annuityOverdueInterest\": 0,\n" +
                "\t\t\t\t\t\"annuityRepaidLoan\": 0,\n" +
                "\t\t\t\t\t\"annuityRepaidInterest\": 0,\n" +
                "\t\t\t\t\t\"annuityRepaidOverdueAmount\": 0,\n" +
                "\t\t\t\t\t\"annuityRepaidOverdueInterest\": 0,\n" +
                "\t\t\t\t\t\"annuityOutAmount\": 673.15\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"annuityPeriodNumber\": 3,\n" +
                "\t\t\t\t\t\"annuityStartDate\": \"2023-02-01\",\n" +
                "\t\t\t\t\t\"annuityEndDate\": \"2023-02-28\",\n" +
                "\t\t\t\t\t\"annuityInAmount\": 673.15,\n" +
                "\t\t\t\t\t\"annuityPaymentAmount\": 178.48,\n" +
                "\t\t\t\t\t\"annuityDueLoan\": 161.61,\n" +
                "\t\t\t\t\t\"annuityDueInterest\": 16.87,\n" +
                "\t\t\t\t\t\"annuityOverdueAmount\": 0,\n" +
                "\t\t\t\t\t\"annuityOverdueInterest\": 0,\n" +
                "\t\t\t\t\t\"annuityRepaidLoan\": 0,\n" +
                "\t\t\t\t\t\"annuityRepaidInterest\": 0,\n" +
                "\t\t\t\t\t\"annuityRepaidOverdueAmount\": 0,\n" +
                "\t\t\t\t\t\"annuityRepaidOverdueInterest\": 0,\n" +
                "\t\t\t\t\t\"annuityOutAmount\": 511.54\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"annuityPeriodNumber\": 4,\n" +
                "\t\t\t\t\t\"annuityStartDate\": \"2023-03-01\",\n" +
                "\t\t\t\t\t\"annuityEndDate\": \"2023-03-31\",\n" +
                "\t\t\t\t\t\"annuityInAmount\": 511.54,\n" +
                "\t\t\t\t\t\"annuityPaymentAmount\": 178.48,\n" +
                "\t\t\t\t\t\"annuityDueLoan\": 166.14,\n" +
                "\t\t\t\t\t\"annuityDueInterest\": 12.34,\n" +
                "\t\t\t\t\t\"annuityOverdueAmount\": 0,\n" +
                "\t\t\t\t\t\"annuityOverdueInterest\": 0,\n" +
                "\t\t\t\t\t\"annuityRepaidLoan\": 0,\n" +
                "\t\t\t\t\t\"annuityRepaidInterest\": 0,\n" +
                "\t\t\t\t\t\"annuityRepaidOverdueAmount\": 0,\n" +
                "\t\t\t\t\t\"annuityRepaidOverdueInterest\": 0,\n" +
                "\t\t\t\t\t\"annuityOutAmount\": 345.4\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"annuityPeriodNumber\": 5,\n" +
                "\t\t\t\t\t\"annuityStartDate\": \"2023-04-01\",\n" +
                "\t\t\t\t\t\"annuityEndDate\": \"2023-04-30\",\n" +
                "\t\t\t\t\t\"annuityInAmount\": 345.4,\n" +
                "\t\t\t\t\t\"annuityPaymentAmount\": 178.48,\n" +
                "\t\t\t\t\t\"annuityDueLoan\": 168.1,\n" +
                "\t\t\t\t\t\"annuityDueInterest\": 10.38,\n" +
                "\t\t\t\t\t\"annuityOverdueAmount\": 0,\n" +
                "\t\t\t\t\t\"annuityOverdueInterest\": 0,\n" +
                "\t\t\t\t\t\"annuityRepaidLoan\": 0,\n" +
                "\t\t\t\t\t\"annuityRepaidInterest\": 0,\n" +
                "\t\t\t\t\t\"annuityRepaidOverdueAmount\": 0,\n" +
                "\t\t\t\t\t\"annuityRepaidOverdueInterest\": 0,\n" +
                "\t\t\t\t\t\"annuityOutAmount\": 177.3\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"annuityPeriodNumber\": 6,\n" +
                "\t\t\t\t\t\"annuityStartDate\": \"2023-05-01\",\n" +
                "\t\t\t\t\t\"annuityEndDate\": \"2023-05-31\",\n" +
                "\t\t\t\t\t\"annuityInAmount\": 177.3,\n" +
                "\t\t\t\t\t\"annuityPaymentAmount\": 184.08,\n" +
                "\t\t\t\t\t\"annuityDueLoan\": 177.3,\n" +
                "\t\t\t\t\t\"annuityDueInterest\": 6.78,\n" +
                "\t\t\t\t\t\"annuityOverdueAmount\": 0,\n" +
                "\t\t\t\t\t\"annuityOverdueInterest\": 0,\n" +
                "\t\t\t\t\t\"annuityRepaidLoan\": 0,\n" +
                "\t\t\t\t\t\"annuityRepaidInterest\": 0,\n" +
                "\t\t\t\t\t\"annuityRepaidOverdueAmount\": 0,\n" +
                "\t\t\t\t\t\"annuityRepaidOverdueInterest\": 0,\n" +
                "\t\t\t\t\t\"annuityOutAmount\": 0\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"annuityPeriodNumber\": 7,\n" +
                "\t\t\t\t\t\"annuityStartDate\": \"2023-06-01\",\n" +
                "\t\t\t\t\t\"annuityEndDate\": \"2023-06-30\",\n" +
                "\t\t\t\t\t\"annuityInAmount\": 0,\n" +
                "\t\t\t\t\t\"annuityPaymentAmount\": 3.59,\n" +
                "\t\t\t\t\t\"annuityDueLoan\": 0,\n" +
                "\t\t\t\t\t\"annuityDueInterest\": 3.59,\n" +
                "\t\t\t\t\t\"annuityOverdueAmount\": 0,\n" +
                "\t\t\t\t\t\"annuityOverdueInterest\": 0,\n" +
                "\t\t\t\t\t\"annuityRepaidLoan\": 0,\n" +
                "\t\t\t\t\t\"annuityRepaidInterest\": 0,\n" +
                "\t\t\t\t\t\"annuityRepaidOverdueAmount\": 0,\n" +
                "\t\t\t\t\t\"annuityRepaidOverdueInterest\": 0,\n" +
                "\t\t\t\t\t\"annuityOutAmount\": 0\n" +
                "\t\t\t\t}\n" +
                "\t\t\t]\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"annuityId\": 3000000000000202,\n" +
                "\t\t\t\"annuityFullAmount\": 10000,\n" +
                "\t\t\t\"annuityInterestRate\": 23.9,\n" +
                "\t\t\t\"annuityResidualAmount\": 10000,\n" +
                "\t\t\t\"annuityCalculatedPaymentAmount\": 1021.3,\n" +
                "\t\t\t\"annuityDate\": \"2022-11-14\",\n" +
                "\t\t\t\"annuityLastDate\": \"2024-04-30\",\n" +
                "\t\t\t\"annuityPaymentQuantity\": 13,\n" +
                "\t\t\t\"annuitySchedule\": [\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"annuityPeriodNumber\": 1,\n" +
                "\t\t\t\t\t\"annuityStartDate\": \"2022-12-01\",\n" +
                "\t\t\t\t\t\"annuityEndDate\": \"2022-12-31\",\n" +
                "\t\t\t\t\t\"annuityInAmount\": 10000,\n" +
                "\t\t\t\t\t\"annuityPaymentAmount\": 1021.3,\n" +
                "\t\t\t\t\t\"annuityDueLoan\": 916.54,\n" +
                "\t\t\t\t\t\"annuityDueInterest\": 104.76,\n" +
                "\t\t\t\t\t\"annuityOverdueAmount\": 0,\n" +
                "\t\t\t\t\t\"annuityOverdueInterest\": 0,\n" +
                "\t\t\t\t\t\"annuityRepaidLoan\": 0,\n" +
                "\t\t\t\t\t\"annuityRepaidInterest\": 0,\n" +
                "\t\t\t\t\t\"annuityRepaidOverdueAmount\": 0,\n" +
                "\t\t\t\t\t\"annuityRepaidOverdueInterest\": 0,\n" +
                "\t\t\t\t\t\"annuityOutAmount\": 9083.46\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"annuityPeriodNumber\": 2,\n" +
                "\t\t\t\t\t\"annuityStartDate\": \"2023-01-01\",\n" +
                "\t\t\t\t\t\"annuityEndDate\": \"2023-01-31\",\n" +
                "\t\t\t\t\t\"annuityInAmount\": 9083.46,\n" +
                "\t\t\t\t\t\"annuityPaymentAmount\": 1021.3,\n" +
                "\t\t\t\t\t\"annuityDueLoan\": 818.32,\n" +
                "\t\t\t\t\t\"annuityDueInterest\": 202.98,\n" +
                "\t\t\t\t\t\"annuityOverdueAmount\": 0,\n" +
                "\t\t\t\t\t\"annuityOverdueInterest\": 0,\n" +
                "\t\t\t\t\t\"annuityRepaidLoan\": 0,\n" +
                "\t\t\t\t\t\"annuityRepaidInterest\": 0,\n" +
                "\t\t\t\t\t\"annuityRepaidOverdueAmount\": 0,\n" +
                "\t\t\t\t\t\"annuityRepaidOverdueInterest\": 0,\n" +
                "\t\t\t\t\t\"annuityOutAmount\": 8265.14\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"annuityPeriodNumber\": 3,\n" +
                "\t\t\t\t\t\"annuityStartDate\": \"2023-02-01\",\n" +
                "\t\t\t\t\t\"annuityEndDate\": \"2023-02-28\",\n" +
                "\t\t\t\t\t\"annuityInAmount\": 8265.14,\n" +
                "\t\t\t\t\t\"annuityPaymentAmount\": 1021.3,\n" +
                "\t\t\t\t\t\"annuityDueLoan\": 836.92,\n" +
                "\t\t\t\t\t\"annuityDueInterest\": 184.38,\n" +
                "\t\t\t\t\t\"annuityOverdueAmount\": 0,\n" +
                "\t\t\t\t\t\"annuityOverdueInterest\": 0,\n" +
                "\t\t\t\t\t\"annuityRepaidLoan\": 0,\n" +
                "\t\t\t\t\t\"annuityRepaidInterest\": 0,\n" +
                "\t\t\t\t\t\"annuityRepaidOverdueAmount\": 0,\n" +
                "\t\t\t\t\t\"annuityRepaidOverdueInterest\": 0,\n" +
                "\t\t\t\t\t\"annuityOutAmount\": 7428.22\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"annuityPeriodNumber\": 4,\n" +
                "\t\t\t\t\t\"annuityStartDate\": \"2023-03-01\",\n" +
                "\t\t\t\t\t\"annuityEndDate\": \"2023-03-31\",\n" +
                "\t\t\t\t\t\"annuityInAmount\": 7428.22,\n" +
                "\t\t\t\t\t\"annuityPaymentAmount\": 1021.3,\n" +
                "\t\t\t\t\t\"annuityDueLoan\": 869.77,\n" +
                "\t\t\t\t\t\"annuityDueInterest\": 151.53,\n" +
                "\t\t\t\t\t\"annuityOverdueAmount\": 0,\n" +
                "\t\t\t\t\t\"annuityOverdueInterest\": 0,\n" +
                "\t\t\t\t\t\"annuityRepaidLoan\": 0,\n" +
                "\t\t\t\t\t\"annuityRepaidInterest\": 0,\n" +
                "\t\t\t\t\t\"annuityRepaidOverdueAmount\": 0,\n" +
                "\t\t\t\t\t\"annuityRepaidOverdueInterest\": 0,\n" +
                "\t\t\t\t\t\"annuityOutAmount\": 6558.45\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"annuityPeriodNumber\": 5,\n" +
                "\t\t\t\t\t\"annuityStartDate\": \"2023-04-01\",\n" +
                "\t\t\t\t\t\"annuityEndDate\": \"2023-04-30\",\n" +
                "\t\t\t\t\t\"annuityInAmount\": 6558.45,\n" +
                "\t\t\t\t\t\"annuityPaymentAmount\": 1021.3,\n" +
                "\t\t\t\t\t\"annuityDueLoan\": 870.52,\n" +
                "\t\t\t\t\t\"annuityDueInterest\": 150.78,\n" +
                "\t\t\t\t\t\"annuityOverdueAmount\": 0,\n" +
                "\t\t\t\t\t\"annuityOverdueInterest\": 0,\n" +
                "\t\t\t\t\t\"annuityRepaidLoan\": 0,\n" +
                "\t\t\t\t\t\"annuityRepaidInterest\": 0,\n" +
                "\t\t\t\t\t\"annuityRepaidOverdueAmount\": 0,\n" +
                "\t\t\t\t\t\"annuityRepaidOverdueInterest\": 0,\n" +
                "\t\t\t\t\t\"annuityOutAmount\": 5687.93\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"annuityPeriodNumber\": 6,\n" +
                "\t\t\t\t\t\"annuityStartDate\": \"2023-05-01\",\n" +
                "\t\t\t\t\t\"annuityEndDate\": \"2023-05-31\",\n" +
                "\t\t\t\t\t\"annuityInAmount\": 5687.93,\n" +
                "\t\t\t\t\t\"annuityPaymentAmount\": 1021.3,\n" +
                "\t\t\t\t\t\"annuityDueLoan\": 892.47,\n" +
                "\t\t\t\t\t\"annuityDueInterest\": 128.83,\n" +
                "\t\t\t\t\t\"annuityOverdueAmount\": 0,\n" +
                "\t\t\t\t\t\"annuityOverdueInterest\": 0,\n" +
                "\t\t\t\t\t\"annuityRepaidLoan\": 0,\n" +
                "\t\t\t\t\t\"annuityRepaidInterest\": 0,\n" +
                "\t\t\t\t\t\"annuityRepaidOverdueAmount\": 0,\n" +
                "\t\t\t\t\t\"annuityRepaidOverdueInterest\": 0,\n" +
                "\t\t\t\t\t\"annuityOutAmount\": 4795.46\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"annuityPeriodNumber\": 7,\n" +
                "\t\t\t\t\t\"annuityStartDate\": \"2023-06-01\",\n" +
                "\t\t\t\t\t\"annuityEndDate\": \"2023-06-30\",\n" +
                "\t\t\t\t\t\"annuityInAmount\": 4795.46,\n" +
                "\t\t\t\t\t\"annuityPaymentAmount\": 1021.3,\n" +
                "\t\t\t\t\t\"annuityDueLoan\": 905.85,\n" +
                "\t\t\t\t\t\"annuityDueInterest\": 115.45,\n" +
                "\t\t\t\t\t\"annuityOverdueAmount\": 0,\n" +
                "\t\t\t\t\t\"annuityOverdueInterest\": 0,\n" +
                "\t\t\t\t\t\"annuityRepaidLoan\": 0,\n" +
                "\t\t\t\t\t\"annuityRepaidInterest\": 0,\n" +
                "\t\t\t\t\t\"annuityRepaidOverdueAmount\": 0,\n" +
                "\t\t\t\t\t\"annuityRepaidOverdueInterest\": 0,\n" +
                "\t\t\t\t\t\"annuityOutAmount\": 3889.61\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"annuityPeriodNumber\": 8,\n" +
                "\t\t\t\t\t\"annuityStartDate\": \"2023-07-01\",\n" +
                "\t\t\t\t\t\"annuityEndDate\": \"2023-07-31\",\n" +
                "\t\t\t\t\t\"annuityInAmount\": 3889.61,\n" +
                "\t\t\t\t\t\"annuityPaymentAmount\": 1021.3,\n" +
                "\t\t\t\t\t\"annuityDueLoan\": 927.1,\n" +
                "\t\t\t\t\t\"annuityDueInterest\": 94.2,\n" +
                "\t\t\t\t\t\"annuityOverdueAmount\": 0,\n" +
                "\t\t\t\t\t\"annuityOverdueInterest\": 0,\n" +
                "\t\t\t\t\t\"annuityRepaidLoan\": 0,\n" +
                "\t\t\t\t\t\"annuityRepaidInterest\": 0,\n" +
                "\t\t\t\t\t\"annuityRepaidOverdueAmount\": 0,\n" +
                "\t\t\t\t\t\"annuityRepaidOverdueInterest\": 0,\n" +
                "\t\t\t\t\t\"annuityOutAmount\": 2962.51\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"annuityPeriodNumber\": 9,\n" +
                "\t\t\t\t\t\"annuityStartDate\": \"2023-08-01\",\n" +
                "\t\t\t\t\t\"annuityEndDate\": \"2023-08-31\",\n" +
                "\t\t\t\t\t\"annuityInAmount\": 2962.51,\n" +
                "\t\t\t\t\t\"annuityPaymentAmount\": 1021.3,\n" +
                "\t\t\t\t\t\"annuityDueLoan\": 942.35,\n" +
                "\t\t\t\t\t\"annuityDueInterest\": 78.95,\n" +
                "\t\t\t\t\t\"annuityOverdueAmount\": 0,\n" +
                "\t\t\t\t\t\"annuityOverdueInterest\": 0,\n" +
                "\t\t\t\t\t\"annuityRepaidLoan\": 0,\n" +
                "\t\t\t\t\t\"annuityRepaidInterest\": 0,\n" +
                "\t\t\t\t\t\"annuityRepaidOverdueAmount\": 0,\n" +
                "\t\t\t\t\t\"annuityRepaidOverdueInterest\": 0,\n" +
                "\t\t\t\t\t\"annuityOutAmount\": 2020.16\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"annuityPeriodNumber\": 10,\n" +
                "\t\t\t\t\t\"annuityStartDate\": \"2023-09-01\",\n" +
                "\t\t\t\t\t\"annuityEndDate\": \"2023-09-30\",\n" +
                "\t\t\t\t\t\"annuityInAmount\": 2020.16,\n" +
                "\t\t\t\t\t\"annuityPaymentAmount\": 1021.3,\n" +
                "\t\t\t\t\t\"annuityDueLoan\": 961.17,\n" +
                "\t\t\t\t\t\"annuityDueInterest\": 60.13,\n" +
                "\t\t\t\t\t\"annuityOverdueAmount\": 0,\n" +
                "\t\t\t\t\t\"annuityOverdueInterest\": 0,\n" +
                "\t\t\t\t\t\"annuityRepaidLoan\": 0,\n" +
                "\t\t\t\t\t\"annuityRepaidInterest\": 0,\n" +
                "\t\t\t\t\t\"annuityRepaidOverdueAmount\": 0,\n" +
                "\t\t\t\t\t\"annuityRepaidOverdueInterest\": 0,\n" +
                "\t\t\t\t\t\"annuityOutAmount\": 1058.99\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"annuityPeriodNumber\": 11,\n" +
                "\t\t\t\t\t\"annuityStartDate\": \"2023-10-01\",\n" +
                "\t\t\t\t\t\"annuityEndDate\": \"2023-10-31\",\n" +
                "\t\t\t\t\t\"annuityInAmount\": 1058.99,\n" +
                "\t\t\t\t\t\"annuityPaymentAmount\": 1021.3,\n" +
                "\t\t\t\t\t\"annuityDueLoan\": 981.62,\n" +
                "\t\t\t\t\t\"annuityDueInterest\": 39.68,\n" +
                "\t\t\t\t\t\"annuityOverdueAmount\": 0,\n" +
                "\t\t\t\t\t\"annuityOverdueInterest\": 0,\n" +
                "\t\t\t\t\t\"annuityRepaidLoan\": 0,\n" +
                "\t\t\t\t\t\"annuityRepaidInterest\": 0,\n" +
                "\t\t\t\t\t\"annuityRepaidOverdueAmount\": 0,\n" +
                "\t\t\t\t\t\"annuityRepaidOverdueInterest\": 0,\n" +
                "\t\t\t\t\t\"annuityOutAmount\": 77.37\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"annuityPeriodNumber\": 12,\n" +
                "\t\t\t\t\t\"annuityStartDate\": \"2023-11-01\",\n" +
                "\t\t\t\t\t\"annuityEndDate\": \"2023-11-30\",\n" +
                "\t\t\t\t\t\"annuityInAmount\": 77.37,\n" +
                "\t\t\t\t\t\"annuityPaymentAmount\": 98.86,\n" +
                "\t\t\t\t\t\"annuityDueLoan\": 77.37,\n" +
                "\t\t\t\t\t\"annuityDueInterest\": 21.49,\n" +
                "\t\t\t\t\t\"annuityOverdueAmount\": 0,\n" +
                "\t\t\t\t\t\"annuityOverdueInterest\": 0,\n" +
                "\t\t\t\t\t\"annuityRepaidLoan\": 0,\n" +
                "\t\t\t\t\t\"annuityRepaidInterest\": 0,\n" +
                "\t\t\t\t\t\"annuityRepaidOverdueAmount\": 0,\n" +
                "\t\t\t\t\t\"annuityRepaidOverdueInterest\": 0,\n" +
                "\t\t\t\t\t\"annuityOutAmount\": 0\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"annuityPeriodNumber\": 13,\n" +
                "\t\t\t\t\t\"annuityStartDate\": \"2023-12-01\",\n" +
                "\t\t\t\t\t\"annuityEndDate\": \"2023-12-31\",\n" +
                "\t\t\t\t\t\"annuityInAmount\": 0,\n" +
                "\t\t\t\t\t\"annuityPaymentAmount\": 1.51,\n" +
                "\t\t\t\t\t\"annuityDueLoan\": 0,\n" +
                "\t\t\t\t\t\"annuityDueInterest\": 1.51,\n" +
                "\t\t\t\t\t\"annuityOverdueAmount\": 0,\n" +
                "\t\t\t\t\t\"annuityOverdueInterest\": 0,\n" +
                "\t\t\t\t\t\"annuityRepaidLoan\": 0,\n" +
                "\t\t\t\t\t\"annuityRepaidInterest\": 0,\n" +
                "\t\t\t\t\t\"annuityRepaidOverdueAmount\": 0,\n" +
                "\t\t\t\t\t\"annuityRepaidOverdueInterest\": 0,\n" +
                "\t\t\t\t\t\"annuityOutAmount\": 0\n" +
                "\t\t\t\t}\n" +
                "\t\t\t]\n" +
                "\t\t}\n" +
                "\t]\n" +
                "}\n";
    }

}
