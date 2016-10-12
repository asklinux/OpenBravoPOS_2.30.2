//    Openbravo POS is a point of sales application designed for touch screens.
//    Copyright (C) 2007-2009 Openbravo, S.L.
//    http://www.openbravo.com/product/pos
//
//    This file is part of Openbravo POS.
//
//    Openbravo POS is free software: you can redistribute it and/or modify
//    it under the terms of the GNU General Public License as published by
//    the Free Software Foundation, either version 3 of the License, or
//    (at your option) any later version.
//
//    Openbravo POS is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//    GNU General Public License for more details.
//
//    You should have received a copy of the GNU General Public License
//    along with Openbravo POS.  If not, see <http://www.gnu.org/licenses/>.

package com.openbravo.pos.panels;

import java.util.List;
import javax.swing.JComponent;
import javax.swing.JPanel;
import com.openbravo.basic.BasicException;
import com.openbravo.pos.forms.AppLocal;
import com.openbravo.pos.forms.JPanelView;
import com.openbravo.pos.forms.AppView;
import com.openbravo.pos.printer.DeviceFiscalPrinter;
import com.openbravo.pos.printer.DevicePrinter;

/**
 *
 * @author adrianromero
 */
public class JPanelPrinter extends JPanel implements JPanelView {

    /** Creates new form JPrinter
     * @param oApp */
    public JPanelPrinter(AppView oApp) {
       
        initComponents();

        
        if (oApp.getDeviceTicket().getDeviceDisplay().getDisplayComponent() != null) {
            m_jDisplay.add(oApp.getDeviceTicket().getDeviceDisplay().getDisplayComponent());
        }     
        
        List<DevicePrinter> aprinters = oApp.getDeviceTicket().getDevicePrinterAll();
        for (int i = 0; i < aprinters.size(); i++) {   
            DevicePrinter printer = aprinters.get(i);
            if (printer.getPrinterComponent() != null) {
                m_jPrinters.add(printer.getPrinterName(), printer.getPrinterComponent());
            }
        }
        
        DeviceFiscalPrinter fp = oApp.getDeviceTicket().getFiscalPrinter();
        if (fp.getFiscalComponent() != null) {
            m_jPrinters.add(fp.getFiscalName(), fp.getFiscalComponent());
        }
    }

    @Override
    public JComponent getComponent() {
        return this;
    }
    @Override
    public String getTitle() {
        return AppLocal.getIntString("Menu.Printer");
    }        
    @Override
    public void activate() throws BasicException {
    }
    @Override
    public boolean deactivate() {
        return true;
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        m_jDisplay = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        m_jPrinters = new javax.swing.JTabbedPane();

        setLayout(new java.awt.BorderLayout());

        add(m_jDisplay, java.awt.BorderLayout.NORTH);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jPanel1.add(m_jPrinters, java.awt.BorderLayout.CENTER);

        add(jPanel1, java.awt.BorderLayout.CENTER);

    }// </editor-fold>//GEN-END:initComponents
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel m_jDisplay;
    private javax.swing.JTabbedPane m_jPrinters;
    // End of variables declaration//GEN-END:variables
    
}
