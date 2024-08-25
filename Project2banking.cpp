// David Brown Project 2 airgead banking
// August 10th, 2024


#include <iostream>
#include <stdio.h>
#include <vector>
#include <iomanip>

using namespace std;


double initialInvestment;
double monthlyDeposit;
int annualInterest;
int numberOfYears;
char run = 's';
vector<double> yearEndBalanceDeposits;
vector<double> yearEndInterestDeposits;
vector<double> yearEndBalanceNoDeposits;
vector<double> yearEndInterestNoDeposits;

void userData() {
    cout << "Input values as needed\n";
    cout << endl;
    cout << "***********************************\n";
    cout << "************ User Data ************\n";
    cout << "Initial Investment Amount: ";
    cin >> initialInvestment;
    cout << "Monthly Deposit: ";
    cin >> monthlyDeposit;
    cout << "Annual Interest as percentage: ";
    cin >> annualInterest;
    cout << "Number of years: ";
    cin >> numberOfYears;
    system("pause");
}

void userDataDisplay() {
    cout << endl << endl;
    cout << "***********************************\n";
    cout << "************ User Data ************\n";
    cout << "Initial Investment Amount: " << initialInvestment << endl;
    cout << "Monthly Deposit: " << monthlyDeposit << endl;
    cout << "Annual Interest as percentage: " << annualInterest << endl;
    cout << "Number of years: " << numberOfYears << endl;
    system("pause");
    
}

void balanceDisplays() {
    cout << endl << endl;
    cout << "   Year End Ealance and Added Anterest Without Deposits   \n";
    cout << "**************************************************************\n";
    cout << "  Year      Year End Balance       Year End Interest Added\n";
    cout << "______________________________________________________________\n";
    cout << endl;
    for (int i = 0; i < yearEndBalanceNoDeposits.size(); i++) {
        cout << fixed << setprecision(2) << right << setw(6) << i + 1 << right << setw(23) << yearEndBalanceNoDeposits[i] << right << setw(29) << yearEndInterestNoDeposits[i] << endl;
        cout << endl;
    }
    cout << endl << endl;
    cout << "      Year End Ealance and Added Anterest With Deposits    \n";
    cout << "**************************************************************\n";
    cout << "  Year      Year End Balance       Year End Interest Added\n";
    cout << "______________________________________________________________\n";
    cout << endl;
    for (int i = 0; i < yearEndBalanceDeposits.size(); i++) {
        cout << fixed << setprecision(2) << right << setw(6) << i + 1 << right << setw(23) << yearEndBalanceDeposits[i] << right << setw(29) << yearEndInterestDeposits[i] << endl;
        cout << endl;
    }

}

void monthlyInterest() {
    int numberOfMonths = numberOfYears * 12;
    double addedInterest;
    double openingAmountNoDeposits = initialInvestment;
    double openingAmountDeposits = initialInvestment;
    cout << endl << openingAmountDeposits << endl;
    double totalInterest = 0;


    for (int i = 1; i <= numberOfMonths; i++) { // Without deposits
        addedInterest = (openingAmountNoDeposits * ((annualInterest / 100.0) / 12.0));
        openingAmountNoDeposits += addedInterest;
        totalInterest += addedInterest;
        if (i % 12 == 0) {
            yearEndBalanceNoDeposits.push_back(openingAmountNoDeposits);
            yearEndInterestNoDeposits.push_back(totalInterest);
            totalInterest = 0;
        }
    }

    for (int i = 1; i <= numberOfMonths; i++) { // With deposits
        addedInterest = ((openingAmountDeposits + monthlyDeposit) * ((annualInterest / 100.0) / 12.0));
        openingAmountDeposits += addedInterest;
        openingAmountDeposits += monthlyDeposit;
        totalInterest += addedInterest;
        if (i % 12 == 0) {
            yearEndBalanceDeposits.push_back(openingAmountDeposits);
            yearEndInterestDeposits.push_back(totalInterest);
            totalInterest = 0;
        }
    }

}

void changeNumbers() {
    char choice;
    cout << endl << endl;
    cout << "Please select an option\n";
    cout << "1: Change Initial Investment\n";
    cout << "2: Change Monthly Deposit\n";
    cout << "3: Change Interst Rate\n";
    cout << "4: Change Length of Investment\n";
    cout << "5: Display Current Data\n";
    cout << "6: Quit Program\n";
    cin >> choice;
    
    switch (choice) {
        case '1':
            cout << "Please input new investment amount:\n";
            cin >> initialInvestment;
            break;

        case '2':
            cout << "Please input new deposit amount:\n";
            cin >> monthlyDeposit;
            break;

        case '3':
            cout << "Please input new interest rate:\n";
            cin >> annualInterest;
            break;

        case '4':
            cout << "Please input new length:\n";
            cin >> numberOfYears;
            break;

        case '5':
            userDataDisplay();
            changeNumbers();
            break;

        case '6':
            cout << endl;
            cout << "Goodbye!";
            cout << endl;
            run = 'q';
            break;

        default:
            cout << endl;
            cout << "Sorry that option is not available.\n Please try again.\n";
            changeNumbers();
            break;
          

    }

}

int main()
{
    userData();

    while (run != 'q') {
        yearEndBalanceDeposits.clear();
        yearEndBalanceNoDeposits.clear();
        yearEndInterestDeposits.clear();
        yearEndInterestNoDeposits.clear();
        monthlyInterest();
        balanceDisplays();
        changeNumbers();
    }



}

