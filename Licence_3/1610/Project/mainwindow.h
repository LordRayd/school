#ifndef MAINWINDOW_H
#define MAINWINDOW_H

#include <QMainWindow>
#include <QTimer>
#include <QTime>

namespace Ui {
class MainWindow;
}

class MainWindow : public QMainWindow
{
    Q_OBJECT

public:
    explicit MainWindow(QWidget *parent = 0);
    ~MainWindow();
    QTimer chronometerTimer;
    QTimer minuteurTimer;
    QTime curTime;
    QTime stopTime;
    QTime minuteurTime;

private slots:
    void on_startButton_clicked();

    void on_stopButton_clicked();

    void on_lapButton_clicked();

    void on_resetButton_clicked();

    void on_countDownButton_clicked();

    void updateChronometerLabel();

    void updateMinuteurLabel();

private:
    Ui::MainWindow *ui;
};

#endif // MAINWINDOW_H
