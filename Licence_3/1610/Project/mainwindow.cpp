#include "mainwindow.h"
#include "ui_mainwindow.h"
#include <QString>
#include <QTextStream>

MainWindow::MainWindow(QWidget *parent) :
    QMainWindow(parent),
    ui(new Ui::MainWindow)
{
    ui->setupUi(this);

    // Connecte les boutton avec leurs action
    QObject::connect(ui->startButton, SIGNAL(clicked()), this, SLOT(on_startButton_clicked()));
    QObject::connect(ui->stopButton, SIGNAL(clicked()), this, SLOT(on_stopButton_clicked()));
    QObject::connect(ui->lapButton, SIGNAL(clicked()), this, SLOT(on_lapButton_clicked()));
    QObject::connect(ui->resetButton, SIGNAL(clicked()), this, SLOT(on_resetButton_clicked()));
    QObject::connect(ui->countDownButton, SIGNAL(clicked()), this, SLOT(on_countDownButton_clicked()));


    connect(&chronometerTimer, SIGNAL(timeout()), this, SLOT(updateChronometerLabel()));
    connect(&minuteurTimer, SIGNAL(timeout()), this, SLOT(updateMinuteurLabel()));

    ui->chronometerTimeLabel->setText(QTime(0, 0).toString("hh:mm:ss:zzz"));
    ui->lastLapLabel->setText(QTime(0, 0).toString("hh:mm:ss:zzz"));
    ui->informationlabel->setText("le minuteur n est pas initialiser");
    stopTime = QTime(0, 0);
}

MainWindow::~MainWindow()
{
    delete ui;
}

void MainWindow::on_startButton_clicked()
{
    curTime = QTime(0,0,0,0);
    curTime.restart();
    chronometerTimer.start();

    ui->resetButton->setEnabled(false);
    ui->startButton->setEnabled(false);
    ui->stopButton->setEnabled(true);
    ui->lapButton->setEnabled(true);
}

void MainWindow::on_stopButton_clicked()
{
    chronometerTimer.stop();
    int h = 0;
    int m = 0;
    int s = curTime.second();
    int ms =curTime.msec();
    stopTime = * new QTime(h,m,s,ms);

    ui->resetButton->setEnabled(true);
    ui->startButton->setEnabled(true);
    ui->stopButton->setEnabled(false);
    ui->lapButton->setEnabled(false);
}

void MainWindow::on_lapButton_clicked()
{
    ui->lastLapLabel->setText(stopTime.addMSecs(curTime.elapsed()).toString("hh:mm:ss:zzz"));
}

void MainWindow::on_resetButton_clicked()
{
    ui->chronometerTimeLabel->setText(QTime(0, 0).toString("hh:mm:ss:zzz"));
    ui->lastLapLabel->setText(QTime(0, 0).toString("hh:mm:ss:zzz"));
    stopTime = QTime(0,0,0,0);
    curTime = QTime(0,0,0,0);
}

void MainWindow::updateChronometerLabel()
{
    ui->chronometerTimeLabel->setText(stopTime.addMSecs(curTime.elapsed()).toString("hh:mm:ss:zzz"));
}

void MainWindow::on_countDownButton_clicked()
{
    int val = ui->minuteurSpinBox->value();
    if(val > 0){
        ui->label_3->setNum(val);

        QString result;
        QTextStream(&result) << "Le minuteur est sur " << val << " secondes";
        ui->informationlabel->setText(result);

        ui->progressBar->setValue(val);
        ui->progressBar->setRange(0, val);

        minuteurTimer.start(1000);
        ui->countDownButton->setEnabled(false);
    }
}
void MainWindow::updateMinuteurLabel()
{
    int val = ui->progressBar->value();
    if(val == -1){
        minuteurTimer.stop();
        ui->informationlabel->setText("le minuteur n est pas initialiser");

    }else{
        ui->progressBar->setValue(val-1);
        if(val>0){
            ui->label_3->setNum(val-1);
        }
        if(val==0)ui->countDownButton->setEnabled(true);
        QApplication::beep();
    }
}
