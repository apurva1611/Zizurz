
package neu.edu.csye6200.controller;

import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import neu.edu.csye6200.data.DataStore;
import neu.edu.csye6200.interfaces.TeacherDataManagement;
import neu.edu.csye6200.interfaces.TeacherDataManagementFactory;
import neu.edu.csye6200.model.ClassRoom;
import neu.edu.csye6200.model.Rules;
import neu.edu.csye6200.model.Teacher;
import neu.edu.csye6200.userInterface.TeacherJPanel;
import neu.edu.csye6200.userInterface.ViewStudentJPanel;

public class TeacherController {
    private static TeacherController instance;
    private TeacherJPanel teacherJPanel;
    public static TeacherController getInstance(TeacherJPanel teacherJPanel) {
            instance = new TeacherController(teacherJPanel);
            return instance;
    }
    private TeacherController(TeacherJPanel teacherJPanel) {
        this.teacherJPanel = teacherJPanel;
        
    }
    public void setTableRecords(){
        DefaultTableModel dtm = (DefaultTableModel)teacherJPanel.getTblTeacherRecords().getModel();
        dtm.setRowCount(0);
        for(Object teacher: TeacherDataManagementFactory.getFactoryInstance().getObject().getDataList()){
            // create a row and pouplate each rules data  in the row
            Teacher t = (Teacher)teacher;
            Object[] row = new Object[dtm.getColumnCount()];
            row[0]= Integer.toString(t.getTeachID());
            row[1]=t.getFirstName();
            row[2]=t.getLastName();
            row[3]=t.getIsAssigned()?t.getClassRoomName():"-";
            dtm.addRow(row);
        }
        teacherJPanel.getBtnDelete().addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {
            // selectedRow contains row selected
          deleteTeacher();
      }});
      teacherJPanel.getBtnUpdateTeacher().addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {
          updateTeacher();
      }});
      teacherJPanel.getBtnAddTeacher().addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {
          addTeacher();
      }});
    }
    public void deleteTeacher(){
        int selectedRow = teacherJPanel.getTblTeacherRecords().getSelectedRow();
        if(selectedRow>=0){
              String id = (String)teacherJPanel.getTblTeacherRecords().getValueAt(selectedRow, 0);
              List<Teacher> teachers = TeacherDataManagementFactory.getFactoryInstance().getObject().getDataList(Integer.parseInt(id));
              if(!teachers.isEmpty()){
                  Teacher t = teachers.get(0);
                  if(!t.getIsAssigned()){
                     TeacherDataManagementFactory.getFactoryInstance().getObject().deleteOneObject(t);
                     JOptionPane.showMessageDialog(null, "Deleted Successfully!");
                      setTableRecords();
                  }
                  else {
                     JOptionPane.showMessageDialog(null, "You cannot delte a assigned Teacher!","Warning",JOptionPane.WARNING_MESSAGE);
                     return;
                  }
              }
              
        }
        else {
            // if user didn't selected a row show message
            JOptionPane.showMessageDialog(null, "Please select a row from table first to delete!","Warning",JOptionPane.WARNING_MESSAGE);
            return;
        }
    }
    public void updateTeacher(){
        int selectedRow = teacherJPanel.getTblTeacherRecords().getSelectedRow();
        if(selectedRow>=0){
              teacherJPanel.updateTeacherJPanel();
              String id = (String) teacherJPanel.getTblTeacherRecords().getValueAt(selectedRow, 0);
              List<Teacher> teachers = TeacherDataManagementFactory.getFactoryInstance().getObject().getDataList(Integer.parseInt(id));
              if(!teachers.isEmpty()){
                  Teacher t = teachers.get(0);
                  setTeacherRecords(t);
                  updateRecord(t);
              }
              
        }
        else {
            // if user didn't selected a row show message
            JOptionPane.showMessageDialog(null, "Please select a row from table first to update!","Warning",JOptionPane.WARNING_MESSAGE);
            return;
        }
        
    }
    public void setTeacherRecords(Teacher t){
        teacherJPanel.getUpdateTeacherJPanel().getTxtFieldFName().setText((t.getFirstName()));
        teacherJPanel.getUpdateTeacherJPanel().getTxtFieldLName().setText((t.getLastName()));
        String name = t.getIsAssigned()? t.getClassRoomName() : "-";
        teacherJPanel.getUpdateTeacherJPanel().getTextFieldClassRoomAssigned().setText(name);
        teacherJPanel.getUpdateTeacherJPanel().getTextFieldTeacherId().setText((Integer.toString(t.getTeachID())));
        
    }
    public void updateRecord(Teacher t){
         teacherJPanel.getUpdateTeacherJPanel().getBtnUpdate().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
            // selectedRow contains row selected
            String fName = teacherJPanel.getUpdateTeacherJPanel().getTxtFieldFName().getText();
            String lName = teacherJPanel.getUpdateTeacherJPanel().getTxtFieldLName().getText();
            if(fName.equals("") || lName.equals("")){
               JOptionPane.showMessageDialog(null,"Enter both fields as both are required" );
               return;
            }
            else{
                t.setFirstName(fName);
                t.setLastName(lName);
                TeacherDataManagementFactory.getFactoryInstance().getObject().updateOneObject(t);
                setTeacherRecords(t);
                JOptionPane.showMessageDialog(null,"Updated Successfully");
                
            }
      }});
        
    }
    public void addTeacher(){
       teacherJPanel.addTeacherJPanel();
       teacherJPanel.getAddTeacherJPanel().getBtnAdd().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
            // selectedRow contains row selected
            String fName = teacherJPanel.getAddTeacherJPanel().getTxtFieldFName().getText();
            String lName = teacherJPanel.getAddTeacherJPanel().getTxtFieldLName().getText();
            if(fName.equals("") || lName.equals("")){
               JOptionPane.showMessageDialog(null,"Enter both fields, as both are required" );
               return;
            }
            else{
                Teacher t = new Teacher(fName,lName,new Date(),0,false,"");
               TeacherDataManagementFactory.getFactoryInstance().getObject().registerOneObject(t);
                setNewTeacherRecord();
                JOptionPane.showMessageDialog(null,"Added Successfully");
                
            }
      }});
       
    }
public void setNewTeacherRecord(){
        teacherJPanel.getAddTeacherJPanel().getTxtFieldFName().setText("");
        teacherJPanel.getAddTeacherJPanel().getTxtFieldLName().setText("");
}


}
