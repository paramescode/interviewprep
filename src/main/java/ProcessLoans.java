
    // #At Affirm, we want to keep track of how much money we are giving out over time. To do this we want to build some sort of API or interface with the following functions:

// # process_loan(loan_amount) // processes a loan
// # get_loan_volume() // returns the amount processed over the past hour

// do we have mush

/*60 * 24 = 1440

1. what process loan does? --
track the loan vol by an hour
    -loandid
    -Timestamp - 1 to n
    -loanamt

Map<Integer, List<l1, l2, l3>>

2.get volms for every hr
    -60 mins from the given time. 60th min -- 59, 58 ....

*/

import java.util.*;

public class ProcessLoans{

        private Map<Integer, List<LoanDetail>> proccessedLoans= new HashMap<>();
        private int min = 1;

        class LoanDetail {

            public int loadid;
            public Double loanAmt;

            LoanDetail(int loanId, Double loanAmt){
                this.loadid = loanId;
                this.loanAmt = loanAmt;
            }
        }

        class LoanVolume {

            public int numberOfLoans;
            public Double totalLoanAmt;

            LoanVolume(int numberOfLoans, Double totalLoanAmt){
                this.numberOfLoans = numberOfLoans;
                this.totalLoanAmt = totalLoanAmt;
            }
        }

        public void process_loan(int min, int loanId, Double loanAmt){
            if(loanId <= 0 || loanAmt < 0)
                return;

            LoanDetail loan = new LoanDetail(loanId, loanAmt);
            proccessedLoans.putIfAbsent(min, new ArrayList<LoanDetail>());
            proccessedLoans.get(min).add(loan);


        }

        public LoanVolume get_loan_volume(int time){

            int totalNumberOfLoans = 0;
            Double totalAmt =0d;

            int end = 0;
            if(time > 60)
                end = time - 60;

            for(int start = time;start > end ; start--){
                List<LoanDetail> loans = proccessedLoans.get(start);
                if(loans == null)
                    continue;
                for(LoanDetail loan :loans){
                    totalNumberOfLoans++;
                    totalAmt += loan.loanAmt;
                }

            }

            return new LoanVolume(totalNumberOfLoans, totalAmt);
        }

        public static void main(String args[]){
            ProcessLoans processLoans = new ProcessLoans();

            processLoans.process_loan(1,1, 100.00);

            // 1 , 100

            processLoans.process_loan(2,3, 100.00);
            processLoans.process_loan(2,2, 100.00);
            // 2, 200
            //2, 300

            processLoans.process_loan(3,4, 100.00);
            //3 , 100

            processLoans.process_loan(60, 5,100.00);

            // 60, 100
            processLoans.process_loan(61, 6,50.00);
            // 61, 50
            processLoans.process_loan(62, 7,50.00);
            //62, 50
            processLoans.process_loan(62,8, 50.00);
            // 100, 50
            processLoans.process_loan(100, 9,50.00);

            LoanVolume loanVolume = processLoans.get_loan_volume(3);

            System.out.println(" loan volume at 30 : " + loanVolume.totalLoanAmt);

            }



}

