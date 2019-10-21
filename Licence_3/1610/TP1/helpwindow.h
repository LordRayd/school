#ifndef HELPWINDOW_H
#define HELPWINDOW_H

#include <QWidget>
#include <QDialog>

class HelpWindow : public QDialog{

public:
    explicit HelpWindow(QWidget *parent = 0);
    ~HelpWindow();
};

#endif // HELPWINDOW_H
