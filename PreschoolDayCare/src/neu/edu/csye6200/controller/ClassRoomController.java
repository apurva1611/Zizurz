
package neu.edu.csye6200.controller;

import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import neu.edu.csye6200.data.DataStore;
import neu.edu.csye6200.interfaces.StudentDataMangementFactory;
import neu.edu.csye6200.interfaces.TeacherDataManagementFactory;
import neu.edu.csye6200.model.ClassRoom;
import neu.edu.csye6200.model.Rules;
import neu.edu.csye6200.model.Student;
import neu.edu.csye6200.model.Teacher;
import neu.edu.csye6200.userInterface.ClassRoomJPanel;
import neu.edu.csye6200.userInterface.ViewStudentJPanel;

public class ClassRoomController {
    private ViewStudentJPanel viewJPanel;
    private ClassRoomJPanel classRoomPanel;
    
    private static ClassRoomController instance;
    public static ClassRoomController getInstance(ClassRoomJPanel classRoomPanel) {
            instance = new ClassRoomController(classRoomPanel);
            return instance;
    }
    private ClassRoomController(ClassRoomJPanel classRoomPanel) {
        this.classRoomPanel = classRoomPanel;
    }
    public void setTableRecords(){
        DefaultTableModel dtm = (DefaultTableModel)classRoomPanel.getTblClassRooms().getModel();
        dtm.setRowCount(0);
        for(Rules rule : DataStore.getInstance().getRules()){
            // create a row and pouplate each rules data  in the row
            Object[] row = new Object[dtm.getColumnCount()];
            if(rule.getMaxAge() == Integer.MAX_VALUE){
               row[0]=rule.getMinAge() + "- and up"; 
            }
            else {
                row[0]=rule.getMinAge() + "-" + rule.getMaxAge();
            }
            row[1]=rule.getGroupSize();
            row[2]=rule.getRatio();
            row[3]= rule.getMaxGroup();
            dtm.addRow(row);
        } 
        this.classRoomPanel.getBtnShowDetail().addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {
            // selectedRow contains row selected
        int selectedRow = classRoomPanel.getTblClassRooms().getSelectedRow();
        if(selectedRow>=0){
              // if user selected a row then open ViewJPanel and display data of selected row
              String age = (String) classRoomPanel.getTblClassRooms().getValueAt(selectedRow, 0);
              String minAge[] = age.split("-");
              ClassRoom c = getClassRoom(Integer.parseInt(minAge[0]));
              viewJPanel = new ViewStudentJPanel(classRoomPanel.getUserProcessControlJPanel());
              populateTableWithStudents(c);
              classRoomPanel.getUserProcessControlJPanel().add("ViewStudentJPanel",viewJPanel);
             CardLayout layout = (CardLayout) classRoomPanel.getUserProcessControlJPanel().getLayout();
              layout.next(classRoomPanel.getUserProcessControlJPanel());
        }
        else {
            // if user didn't selected a row show message
            JOptionPane.showMessageDialog(null, "Please select a row from table first to view Details!","Warning",JOptionPane.WARNING_MESSAGE);
        }
      }});
    }
    public void populateTableWithStudents( ClassRoom c){
        DefaultTableModel dtm = (DefaultTableModel)viewJPanel.getTblStudents().getModel();
        dtm.setRowCount(0);
        List<Student> students = StudentDataMangementFactory.getFactoryInstance().getObject().getDataList(c.getMinAge(),c.getMaxAge());
        System.out.println(c.getMinAge()+" " + c.getMaxAge());
        for(Student s :students){
            // create a row and pouplate each rules data  in the row
            Object[] row = new Object[dtm.getColumnCount()];
            row[0]=s.firstName;
            row[1]=s.lastName;
            row[2]=s.getAge();
            row[3]= s.getStuId();
            dtm.addRow(row);
    }
    populateTeacherRecords(c);
    }
    public void populateTeacherRecords(ClassRoom c){
        List<Teacher> teacher = TeacherDataManagementFactory.getFactoryInstance().getObject().getDataList(c.getName());
        
        if(!teacher.isEmpty()){
           Teacher t = teacher.get(0);
           String pattern = "dd/MM/yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(t.registerTime);
           System.out.println(t.getClassRoomName());
            viewJPanel.getTextFieldFName().setText(t.getFirstName());
            viewJPanel.getTextFieldLName().setText(t.getLastName());
            viewJPanel.getTextFieldTime().setText(date);
            viewJPanel.getTextFieldId().setText(Integer.toString(t.getTeachID()));
            
        }
    }
    public ClassRoom getClassRoom(int minAge){
        for(ClassRoom c:DataStore.getInstance().getClassrooms()){
            if(minAge == c.getMinAge()){
                return c;
            }
        }
        return null;
    }
}
