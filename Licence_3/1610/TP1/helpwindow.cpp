#include "helpwindow.h"

HelpWindow::HelpWindow(QWidget *parent) : QDialog(parent){
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

}

HelpWindow::~HelpWindow()
{
    delete ui;
}
