#include "mainwindow.h"
#include "ui_mainwindow.h"
#include <QMenu>

MainWindow::MainWindow(QWidget *parent) : QMainWindow(parent), ui(new Ui::MainWindow){
    ui->setupUi(this);
    setWindowTitle(tr("Menus"));
    setMinimumSize(160, 160);

    QMenu *menuFichier = menuBar()->addMenu("&Fichier");
    QAction *actionQuitter = new QAction("&Quitter", this);
    menuFichier->addAction(actionQuitter);
    QMenu *menuEdition = menuBar()->addMenu("&Edition");
    QMenu *menuAffichage = menuBar()->addMenu("&Affichage");
    QMenu *menuAide = menuBar()->addMenu("&Aide");
    QAction *actionAide = new QAction("&A propos", this);
    menuAide->addAction(actionAide);

    connect(actionQuitter, SIGNAL(triggered()), qApp, SLOT(openNewWindow()));

}

MainWindow::~MainWindow(){
    delete ui;
}

void MainWindow::openNewWindow(){
   mMyHelpWindow = new HelpWindow();
   mMyHelpWindow->show();
}
