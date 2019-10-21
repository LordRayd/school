/********************************************************************************
** Form generated from reading UI file 'mainwindow.ui'
**
** Created by: Qt User Interface Compiler version 5.9.2
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_MAINWINDOW_H
#define UI_MAINWINDOW_H

#include <QtCore/QVariant>
#include <QtWidgets/QAction>
#include <QtWidgets/QApplication>
#include <QtWidgets/QButtonGroup>
#include <QtWidgets/QGridLayout>
#include <QtWidgets/QHBoxLayout>
#include <QtWidgets/QHeaderView>
#include <QtWidgets/QLabel>
#include <QtWidgets/QMainWindow>
#include <QtWidgets/QMenuBar>
#include <QtWidgets/QProgressBar>
#include <QtWidgets/QPushButton>
#include <QtWidgets/QSpinBox>
#include <QtWidgets/QStatusBar>
#include <QtWidgets/QToolBar>
#include <QtWidgets/QVBoxLayout>
#include <QtWidgets/QWidget>

QT_BEGIN_NAMESPACE

class Ui_MainWindow
{
public:
    QWidget *centralWidget;
    QWidget *gridLayoutWidget;
    QGridLayout *gridLayout;
    QVBoxLayout *chronometreLayout;
    QVBoxLayout *verticalLayout_3;
    QLabel *label;
    QVBoxLayout *verticalLayout;
    QHBoxLayout *horizontalLayout_5;
    QHBoxLayout *horizontalLayout_8;
    QPushButton *startButton;
    QHBoxLayout *horizontalLayout_7;
    QLabel *chronometerTimeLabel;
    QHBoxLayout *horizontalLayout_6;
    QPushButton *lapButton;
    QVBoxLayout *verticalLayout_2;
    QHBoxLayout *horizontalLayout;
    QHBoxLayout *horizontalLayout_4;
    QPushButton *stopButton;
    QHBoxLayout *horizontalLayout_3;
    QLabel *lastLapLabel;
    QHBoxLayout *horizontalLayout_2;
    QPushButton *resetButton;
    QVBoxLayout *minuteurLayout;
    QVBoxLayout *verticalLayout_4;
    QLabel *label_2;
    QVBoxLayout *verticalLayout_5;
    QHBoxLayout *horizontalLayout_9;
    QHBoxLayout *horizontalLayout_12;
    QSpinBox *minuteurSpinBox;
    QHBoxLayout *horizontalLayout_11;
    QVBoxLayout *verticalLayout_6;
    QVBoxLayout *verticalLayout_8;
    QLabel *label_3;
    QVBoxLayout *verticalLayout_7;
    QProgressBar *progressBar;
    QHBoxLayout *horizontalLayout_10;
    QPushButton *countDownButton;
    QVBoxLayout *infoLayout;
    QHBoxLayout *horizontalLayout_13;
    QHBoxLayout *horizontalLayout_15;
    QLabel *informationlabel;
    QHBoxLayout *horizontalLayout_14;
    QPushButton *exitButton;
    QMenuBar *menuBar;
    QToolBar *mainToolBar;
    QStatusBar *statusBar;

    void setupUi(QMainWindow *MainWindow)
    {
        if (MainWindow->objectName().isEmpty())
            MainWindow->setObjectName(QStringLiteral("MainWindow"));
        MainWindow->resize(1051, 649);
        centralWidget = new QWidget(MainWindow);
        centralWidget->setObjectName(QStringLiteral("centralWidget"));
        gridLayoutWidget = new QWidget(centralWidget);
        gridLayoutWidget->setObjectName(QStringLiteral("gridLayoutWidget"));
        gridLayoutWidget->setGeometry(QRect(0, 0, 1031, 581));
        gridLayout = new QGridLayout(gridLayoutWidget);
        gridLayout->setSpacing(6);
        gridLayout->setContentsMargins(11, 11, 11, 11);
        gridLayout->setObjectName(QStringLiteral("gridLayout"));
        gridLayout->setContentsMargins(0, 0, 0, 0);
        chronometreLayout = new QVBoxLayout();
        chronometreLayout->setSpacing(6);
        chronometreLayout->setObjectName(QStringLiteral("chronometreLayout"));
        verticalLayout_3 = new QVBoxLayout();
        verticalLayout_3->setSpacing(6);
        verticalLayout_3->setObjectName(QStringLiteral("verticalLayout_3"));
        label = new QLabel(gridLayoutWidget);
        label->setObjectName(QStringLiteral("label"));
        QFont font;
        font.setBold(true);
        font.setWeight(75);
        label->setFont(font);

        verticalLayout_3->addWidget(label);


        chronometreLayout->addLayout(verticalLayout_3);

        verticalLayout = new QVBoxLayout();
        verticalLayout->setSpacing(6);
        verticalLayout->setObjectName(QStringLiteral("verticalLayout"));
        horizontalLayout_5 = new QHBoxLayout();
        horizontalLayout_5->setSpacing(6);
        horizontalLayout_5->setObjectName(QStringLiteral("horizontalLayout_5"));
        horizontalLayout_8 = new QHBoxLayout();
        horizontalLayout_8->setSpacing(6);
        horizontalLayout_8->setObjectName(QStringLiteral("horizontalLayout_8"));
        startButton = new QPushButton(gridLayoutWidget);
        startButton->setObjectName(QStringLiteral("startButton"));
        startButton->setMaximumSize(QSize(16000000, 16777215));

        horizontalLayout_8->addWidget(startButton);


        horizontalLayout_5->addLayout(horizontalLayout_8);

        horizontalLayout_7 = new QHBoxLayout();
        horizontalLayout_7->setSpacing(6);
        horizontalLayout_7->setObjectName(QStringLiteral("horizontalLayout_7"));
        chronometerTimeLabel = new QLabel(gridLayoutWidget);
        chronometerTimeLabel->setObjectName(QStringLiteral("chronometerTimeLabel"));
        chronometerTimeLabel->setAlignment(Qt::AlignCenter);

        horizontalLayout_7->addWidget(chronometerTimeLabel);


        horizontalLayout_5->addLayout(horizontalLayout_7);

        horizontalLayout_6 = new QHBoxLayout();
        horizontalLayout_6->setSpacing(6);
        horizontalLayout_6->setObjectName(QStringLiteral("horizontalLayout_6"));
        lapButton = new QPushButton(gridLayoutWidget);
        lapButton->setObjectName(QStringLiteral("lapButton"));

        horizontalLayout_6->addWidget(lapButton);


        horizontalLayout_5->addLayout(horizontalLayout_6);


        verticalLayout->addLayout(horizontalLayout_5);


        chronometreLayout->addLayout(verticalLayout);

        verticalLayout_2 = new QVBoxLayout();
        verticalLayout_2->setSpacing(6);
        verticalLayout_2->setObjectName(QStringLiteral("verticalLayout_2"));
        horizontalLayout = new QHBoxLayout();
        horizontalLayout->setSpacing(6);
        horizontalLayout->setObjectName(QStringLiteral("horizontalLayout"));
        horizontalLayout_4 = new QHBoxLayout();
        horizontalLayout_4->setSpacing(6);
        horizontalLayout_4->setObjectName(QStringLiteral("horizontalLayout_4"));
        stopButton = new QPushButton(gridLayoutWidget);
        stopButton->setObjectName(QStringLiteral("stopButton"));

        horizontalLayout_4->addWidget(stopButton);


        horizontalLayout->addLayout(horizontalLayout_4);

        horizontalLayout_3 = new QHBoxLayout();
        horizontalLayout_3->setSpacing(6);
        horizontalLayout_3->setObjectName(QStringLiteral("horizontalLayout_3"));
        lastLapLabel = new QLabel(gridLayoutWidget);
        lastLapLabel->setObjectName(QStringLiteral("lastLapLabel"));
        lastLapLabel->setAlignment(Qt::AlignCenter);

        horizontalLayout_3->addWidget(lastLapLabel);


        horizontalLayout->addLayout(horizontalLayout_3);

        horizontalLayout_2 = new QHBoxLayout();
        horizontalLayout_2->setSpacing(6);
        horizontalLayout_2->setObjectName(QStringLiteral("horizontalLayout_2"));
        resetButton = new QPushButton(gridLayoutWidget);
        resetButton->setObjectName(QStringLiteral("resetButton"));

        horizontalLayout_2->addWidget(resetButton);


        horizontalLayout->addLayout(horizontalLayout_2);


        verticalLayout_2->addLayout(horizontalLayout);


        chronometreLayout->addLayout(verticalLayout_2);


        gridLayout->addLayout(chronometreLayout, 1, 0, 1, 1);

        minuteurLayout = new QVBoxLayout();
        minuteurLayout->setSpacing(6);
        minuteurLayout->setObjectName(QStringLiteral("minuteurLayout"));
        verticalLayout_4 = new QVBoxLayout();
        verticalLayout_4->setSpacing(6);
        verticalLayout_4->setObjectName(QStringLiteral("verticalLayout_4"));
        label_2 = new QLabel(gridLayoutWidget);
        label_2->setObjectName(QStringLiteral("label_2"));
        label_2->setFont(font);

        verticalLayout_4->addWidget(label_2);


        minuteurLayout->addLayout(verticalLayout_4);

        verticalLayout_5 = new QVBoxLayout();
        verticalLayout_5->setSpacing(6);
        verticalLayout_5->setObjectName(QStringLiteral("verticalLayout_5"));
        horizontalLayout_9 = new QHBoxLayout();
        horizontalLayout_9->setSpacing(6);
        horizontalLayout_9->setObjectName(QStringLiteral("horizontalLayout_9"));
        horizontalLayout_12 = new QHBoxLayout();
        horizontalLayout_12->setSpacing(6);
        horizontalLayout_12->setObjectName(QStringLiteral("horizontalLayout_12"));
        minuteurSpinBox = new QSpinBox(gridLayoutWidget);
        minuteurSpinBox->setObjectName(QStringLiteral("minuteurSpinBox"));

        horizontalLayout_12->addWidget(minuteurSpinBox);


        horizontalLayout_9->addLayout(horizontalLayout_12);

        horizontalLayout_11 = new QHBoxLayout();
        horizontalLayout_11->setSpacing(6);
        horizontalLayout_11->setObjectName(QStringLiteral("horizontalLayout_11"));
        verticalLayout_6 = new QVBoxLayout();
        verticalLayout_6->setSpacing(6);
        verticalLayout_6->setObjectName(QStringLiteral("verticalLayout_6"));
        verticalLayout_8 = new QVBoxLayout();
        verticalLayout_8->setSpacing(6);
        verticalLayout_8->setObjectName(QStringLiteral("verticalLayout_8"));
        label_3 = new QLabel(gridLayoutWidget);
        label_3->setObjectName(QStringLiteral("label_3"));
        label_3->setAlignment(Qt::AlignCenter);

        verticalLayout_8->addWidget(label_3);


        verticalLayout_6->addLayout(verticalLayout_8);

        verticalLayout_7 = new QVBoxLayout();
        verticalLayout_7->setSpacing(6);
        verticalLayout_7->setObjectName(QStringLiteral("verticalLayout_7"));
        progressBar = new QProgressBar(gridLayoutWidget);
        progressBar->setObjectName(QStringLiteral("progressBar"));
        progressBar->setValue(100);
        progressBar->setTextVisible(false);
        progressBar->setOrientation(Qt::Horizontal);

        verticalLayout_7->addWidget(progressBar);


        verticalLayout_6->addLayout(verticalLayout_7);


        horizontalLayout_11->addLayout(verticalLayout_6);


        horizontalLayout_9->addLayout(horizontalLayout_11);

        horizontalLayout_10 = new QHBoxLayout();
        horizontalLayout_10->setSpacing(6);
        horizontalLayout_10->setObjectName(QStringLiteral("horizontalLayout_10"));
        countDownButton = new QPushButton(gridLayoutWidget);
        countDownButton->setObjectName(QStringLiteral("countDownButton"));

        horizontalLayout_10->addWidget(countDownButton);


        horizontalLayout_9->addLayout(horizontalLayout_10);


        verticalLayout_5->addLayout(horizontalLayout_9);


        minuteurLayout->addLayout(verticalLayout_5);


        gridLayout->addLayout(minuteurLayout, 2, 0, 1, 1);

        infoLayout = new QVBoxLayout();
        infoLayout->setSpacing(6);
        infoLayout->setObjectName(QStringLiteral("infoLayout"));
        horizontalLayout_13 = new QHBoxLayout();
        horizontalLayout_13->setSpacing(6);
        horizontalLayout_13->setObjectName(QStringLiteral("horizontalLayout_13"));
        horizontalLayout_15 = new QHBoxLayout();
        horizontalLayout_15->setSpacing(6);
        horizontalLayout_15->setObjectName(QStringLiteral("horizontalLayout_15"));
        informationlabel = new QLabel(gridLayoutWidget);
        informationlabel->setObjectName(QStringLiteral("informationlabel"));
        informationlabel->setAlignment(Qt::AlignCenter);

        horizontalLayout_15->addWidget(informationlabel);


        horizontalLayout_13->addLayout(horizontalLayout_15);

        horizontalLayout_14 = new QHBoxLayout();
        horizontalLayout_14->setSpacing(6);
        horizontalLayout_14->setObjectName(QStringLiteral("horizontalLayout_14"));
        exitButton = new QPushButton(gridLayoutWidget);
        exitButton->setObjectName(QStringLiteral("exitButton"));

        horizontalLayout_14->addWidget(exitButton);


        horizontalLayout_13->addLayout(horizontalLayout_14);


        infoLayout->addLayout(horizontalLayout_13);


        gridLayout->addLayout(infoLayout, 0, 0, 1, 1);

        MainWindow->setCentralWidget(centralWidget);
        menuBar = new QMenuBar(MainWindow);
        menuBar->setObjectName(QStringLiteral("menuBar"));
        menuBar->setGeometry(QRect(0, 0, 1051, 28));
        MainWindow->setMenuBar(menuBar);
        mainToolBar = new QToolBar(MainWindow);
        mainToolBar->setObjectName(QStringLiteral("mainToolBar"));
        MainWindow->addToolBar(Qt::TopToolBarArea, mainToolBar);
        statusBar = new QStatusBar(MainWindow);
        statusBar->setObjectName(QStringLiteral("statusBar"));
        MainWindow->setStatusBar(statusBar);

        retranslateUi(MainWindow);
        QObject::connect(exitButton, SIGNAL(clicked()), MainWindow, SLOT(close()));

        QMetaObject::connectSlotsByName(MainWindow);
    } // setupUi

    void retranslateUi(QMainWindow *MainWindow)
    {
        MainWindow->setWindowTitle(QApplication::translate("MainWindow", "MainWindow", Q_NULLPTR));
        label->setText(QApplication::translate("MainWindow", "Chronometre", Q_NULLPTR));
        startButton->setText(QApplication::translate("MainWindow", "Start", Q_NULLPTR));
        chronometerTimeLabel->setText(QApplication::translate("MainWindow", "TextLabel", Q_NULLPTR));
        lapButton->setText(QApplication::translate("MainWindow", "Lap", Q_NULLPTR));
        stopButton->setText(QApplication::translate("MainWindow", "Stop", Q_NULLPTR));
        lastLapLabel->setText(QApplication::translate("MainWindow", "TextLabel", Q_NULLPTR));
        resetButton->setText(QApplication::translate("MainWindow", "Reset", Q_NULLPTR));
        label_2->setText(QApplication::translate("MainWindow", "Minuteur", Q_NULLPTR));
        label_3->setText(QApplication::translate("MainWindow", "0", Q_NULLPTR));
        countDownButton->setText(QApplication::translate("MainWindow", "Count Down", Q_NULLPTR));
        informationlabel->setText(QApplication::translate("MainWindow", "TextLabel", Q_NULLPTR));
        exitButton->setText(QApplication::translate("MainWindow", "Exit", Q_NULLPTR));
    } // retranslateUi

};

namespace Ui {
    class MainWindow: public Ui_MainWindow {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_MAINWINDOW_H
