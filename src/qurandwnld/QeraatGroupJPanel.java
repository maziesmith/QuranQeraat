/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qurandwnld;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import javax.swing.DefaultListModel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

/**
 *
 * @author ibraheem
 */
public class QeraatGroupJPanel extends javax.swing.JPanel {

    static final SelectionType[] selectionTypes = {
        SelectionType.Farsh,
        SelectionType.Hamz,
        SelectionType.Edgham,
        SelectionType.Emalah,
        SelectionType.Naql,
        SelectionType.Mad,
        SelectionType.Sakt
    };
    
    private final List<JRadioButton> radioButtons;
    private final SelectionDetail temp = new SelectionDetail();
    private SelectionDetail current;
    SelectionType currentType = SelectionType.Farsh;
    
    private TableModel getTableModel() {
        return new DefaultTableModel(new String [] {
                "المتن", "رقم البيت", "الشطر الأول", "الشطر الثاني"
            }, 0){
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, 
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };
         
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        };
    }
    
    /**
     * Creates new form QeraatGroupJPanel
     */
    public QeraatGroupJPanel() {
        initComponents();
        radioButtons = Arrays.asList(new JRadioButton[] {
            jRadioButtonFarsh,
            jRadioButtonHamz,
            jRadioButtonEdgham,
            jRadioButtonEmalah,
            jRadioButtonNaql,
            jRadioButtonMadd,
            jRadioButtonSakt
        });
        ChangeListener changeListener = (evt) -> {
            JRadioButton btn = (JRadioButton) evt.getSource();
            if (btn.isSelected()) {
                int idx = radioButtons.indexOf(btn);
                currentType = selectionTypes[idx];
            }
        };
        radioButtons.stream().forEach((r) -> {
            r.addChangeListener(changeListener);
        });
        initMenues();
        int[] colWidth = {100, 50, 200, 200};
        for (int i = 0; i < colWidth.length; ++i)
            jTable2.getColumnModel().getColumn(i).setPreferredWidth(colWidth[i]);
        WriteJFrame1.rtlLayout(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenu_Ramz = new javax.swing.JMenu();
        jMenu_Qeraah = new javax.swing.JMenu();
        jMenuRewayah = new javax.swing.JMenu();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem4 = new javax.swing.JMenuItem();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabelPreview = new javax.swing.JLabel();
        jRadioButtonSakt = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jRadioButtonFarsh = new javax.swing.JRadioButton();
        jRadioButtonHamz = new javax.swing.JRadioButton();
        jRadioButtonEdgham = new javax.swing.JRadioButton();
        jRadioButtonEmalah = new javax.swing.JRadioButton();
        jRadioButtonNaql = new javax.swing.JRadioButton();
        jRadioButtonMadd = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        jMenuItem1.setText("إزالة");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);
        jPopupMenu1.add(jSeparator2);

        jMenu_Ramz.setText("إضافة رمز");
        jPopupMenu1.add(jMenu_Ramz);

        jMenu_Qeraah.setText("إضافة قراءة");
        jPopupMenu1.add(jMenu_Qeraah);

        jMenuRewayah.setText("إضافة رواية");
        jPopupMenu1.add(jMenuRewayah);

        jMenu1.setText("إضافة بيت");

        jMenuItem2.setText("من الشاطبية");
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("من الدرة");
        jMenu1.add(jMenuItem3);

        jPopupMenu2.add(jMenu1);
        jPopupMenu2.add(jSeparator1);

        jMenuItem4.setText("حذف البيت المحدد");
        jPopupMenu2.add(jMenuItem4);

        jLabel2.setText("الوصف");

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Traditional Arabic", 1, 18)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabelPreview.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelPreview.setForeground(new java.awt.Color(255, 51, 51));
        jLabelPreview.setText("قرأ فلان وفلان بـ كذا وكذا");
        jLabelPreview.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        buttonGroup1.add(jRadioButtonSakt);
        jRadioButtonSakt.setText("سكت");

        jLabel3.setText("نوع الخلاف");

        buttonGroup1.add(jRadioButtonFarsh);
        jRadioButtonFarsh.setSelected(true);
        jRadioButtonFarsh.setText("فرش");

        buttonGroup1.add(jRadioButtonHamz);
        jRadioButtonHamz.setText("همز");

        buttonGroup1.add(jRadioButtonEdgham);
        jRadioButtonEdgham.setText("إدغام/اختلاس");

        buttonGroup1.add(jRadioButtonEmalah);
        jRadioButtonEmalah.setText("إمالة");

        buttonGroup1.add(jRadioButtonNaql);
        jRadioButtonNaql.setText("نقل");

        buttonGroup1.add(jRadioButtonMadd);
        jRadioButtonMadd.setText("مد");

        jLabel4.setText("الشاهد");

        jTable2.setModel(getTableModel());
        jTable2.setComponentPopupMenu(jPopupMenu2);
        jScrollPane4.setViewportView(jTable2);

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("الروايات");
        javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("أهل عم");
        javax.swing.tree.DefaultMutableTreeNode treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("نافع");
        javax.swing.tree.DefaultMutableTreeNode treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("قالون");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("ورش");
        treeNode3.add(treeNode4);
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("ابن عامر");
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("هشام");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("ابن ذكوان");
        treeNode3.add(treeNode4);
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("عاصم");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("حفص");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("شعبة");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        jTree1.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jTree1.setComponentPopupMenu(jPopupMenu1);
        jScrollPane3.setViewportView(jTree1);

        jLabel6.setText("شجرة القراء");

        jButton1.setText("إضافة");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabelPreview, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButtonFarsh)
                            .addComponent(jRadioButtonHamz)
                            .addComponent(jRadioButtonEdgham)
                            .addComponent(jRadioButtonMadd)
                            .addComponent(jRadioButtonNaql)
                            .addComponent(jRadioButtonEmalah)
                            .addComponent(jLabel3)
                            .addComponent(jRadioButtonSakt))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel6))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jRadioButtonFarsh)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jRadioButtonHamz)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jRadioButtonEdgham)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jRadioButtonEmalah)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jRadioButtonNaql)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jRadioButtonMadd))
                                .addComponent(jScrollPane1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButtonSakt)
                            .addComponent(jLabelPreview, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addGap(15, 15, 15))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        if (jTree1.getSelectionPath() != null) {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) 
                    jTree1.getSelectionPath().getLastPathComponent();
            if (node != null &&
                    (node.getUserObject() instanceof QeraahGroup
                    || node.getUserObject() instanceof Qeraah
                    || node.getUserObject() instanceof MyRewayah)) {
                ((DefaultMutableTreeNode) node.getParent()).remove(node);
                ((DefaultTreeModel) jTree1.getModel()).setRoot(
                        (TreeNode) jTree1.getModel().getRoot());
            }
        }
        get(temp);
        jLabelPreview.setText(temp.toString());
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int sel = JOptionPane.showOptionDialog(getParent(), "فضلا حدد المتن:", "إضافة شاهد", 
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, 
                new Object[]{"الشاطبية", "الدرة"}, null);
        if (sel != JOptionPane.CLOSED_OPTION) {
            work(sel == 1, current);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    void set(SelectionDetail s) {
        jTextArea1.setText(s.descr);
        radioButtons.get(s.type.getValue() - 1).setSelected(true);
        current = s;
        buildTree();
        updateShahed();
        jLabelPreview.setText(current.toString());
    }
    
    void get(SelectionDetail current) {
        current.descr = jTextArea1.getText();
        current.rewayaat = new RewayahSelectionList();
        current.type = currentType;
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) jTree1.getModel().getRoot();
        for (int i = 0; i < root.getChildCount(); ++i) {
            DefaultMutableTreeNode child = (DefaultMutableTreeNode) root.getChildAt(i);
            if (child.getUserObject() instanceof QeraahGroup) {
                QeraahGroup g = (QeraahGroup) child.getUserObject();
                for (Qeraah q : g.qeraat) {
                    current.rewayaat.add(Rewayah.getByCombinedCode(q.code + ".1"));
                    current.rewayaat.add(Rewayah.getByCombinedCode(q.code + ".2"));
                }
            } else if (child.getUserObject() instanceof Qeraah) {
                Qeraah q = (Qeraah) child.getUserObject();
                current.rewayaat.add(Rewayah.getByCombinedCode(q.code + ".1"));
                current.rewayaat.add(Rewayah.getByCombinedCode(q.code + ".2"));
            } else if (child.getUserObject() instanceof MyRewayah) {
                MyRewayah m = (MyRewayah) child.getUserObject();
                current.rewayaat.add(m.r);
            }
        }
        current.dorrah.clear();
        current.shatibiyyah.clear();
        for (int i = 0; i < jTable2.getRowCount(); ++i) {
            Shahed s = new Shahed();
            s.id = Integer.parseInt(jTable2.getValueAt(i, 1).toString());
            s.part1 = (String) jTable2.getValueAt(i, 2);
            s.part2 = (String) jTable2.getValueAt(i, 3);
            if (jTable2.getValueAt(i, 0).equals("الشاطبية")) {
                current.shatibiyyah.add(s);
            } else {
                current.dorrah.add(s);
            }
        }
    }
    
    SelectionDetail get() {
        get(current);
        return current;
    }
    
    private void buildTree() {
        DefaultTreeModel model = (DefaultTreeModel) jTree1.getModel();
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("القراء");
        jLabelPreview.setText(current.toString());
        for (Object o : current.lastGroupingResult)
            buildTree(root, o);
        model.setRoot(root);
    }
    
    static class MyRewayah {
        final Rewayah r;
        final DefaultMutableTreeNode parent;
        
        public MyRewayah(Rewayah r, DefaultMutableTreeNode parent) {
            this.r = r;
            this.parent = parent;
        }

        @Override
        public String toString() {
            return parent.getUserObject() instanceof Qeraah ?
                    r.rewayah : r.toString();
        }
    }
    
    private void buildTree(DefaultMutableTreeNode parent, Object obj) {
        if (obj instanceof QeraahGroup) {
            QeraahGroup g = (QeraahGroup) obj;
            DefaultMutableTreeNode node = new DefaultMutableTreeNode(g);
            for (Qeraah q : g.qeraat)
                buildTree(node, q);
            parent.add(node);
        } else if (obj instanceof Qeraah) {
            Qeraah q = (Qeraah) obj;
            DefaultMutableTreeNode node = new DefaultMutableTreeNode(q);
            buildTree(node, Rewayah.getByCombinedCode(q.code + ".1"));
            buildTree(node, Rewayah.getByCombinedCode(q.code + ".2"));
            parent.add(node);
        } else if (obj instanceof Rewayah) {
            parent.add(new DefaultMutableTreeNode(new MyRewayah((Rewayah) obj, parent)));
        } else
            throw new IllegalArgumentException();
    }
    
    private boolean compare(Map<Integer, String> sel1, Map<Integer, String> sel2) {
        if (sel1.size() != sel2.size()) return false;
        boolean yes = true;
        for (Map.Entry<Integer, String> k : sel1.entrySet()) {
            String get = sel2.get(k.getKey());
            if (!Objects.equals(get, k.getValue())) {
                yes = false;
                break;
            }
        }
        return yes;
    }
    
    private void work(boolean isDorrah, SelectionDetail detail) {
        Map<Integer, String> init = new LinkedHashMap<>();
        if (detail.dorrah == null)
            detail.dorrah = new ArrayList<>();
        if (detail.shatibiyyah == null)
            detail.shatibiyyah = new ArrayList<>();
        ArrayList<Shahed> list = isDorrah ? detail.dorrah : detail.shatibiyyah;
        list.stream().forEach(k -> {
            init.put(k.id, k.words);
        });
        int page = 1;
        if (!init.isEmpty()) {
            int beit = init.entrySet().iterator().next().getKey();
            page = DbHelper.getMatnPageByBeit(beit, isDorrah);
        }
        ChooseShahedJFrame2 frame = new ChooseShahedJFrame2(isDorrah, page);
        list.stream().forEach(k -> {
            frame.addSelection(k.id, k.words);
        });
        if (JOptionPane.showConfirmDialog(this, frame.getContentPane(), "تحديد الشاهد",
                JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
            Map<Integer, String> sel = frame.getSelectionsAsWordsString();
            if (!compare(init, sel)) {
                List<Integer> ids = sel.keySet().stream().collect(Collectors.toList());
                ids.sort((i, j) -> i.compareTo(j));
                ArrayList<Shahed> sh = DbHelper.getShahedList(ids, isDorrah);
                list.clear();
                sh.stream().forEach(h -> {
                    h.words = sel.get(h.id);
                    list.add(h);
                });
                DbHelper.updateShaheds(detail);
                updateShahed();
            }
        }
    }
    
    private String getWords(String part, String words, boolean isFirstPart) {
        String[] arr = part.trim().split(" ");
        String prefix = isFirstPart ? "1" : "2";
        String[] w = words.split(";");
        String res = "";
        for (String idx : Arrays.stream(w).filter(k -> k.startsWith(prefix))
                .collect(Collectors.toList())) {
            byte i = Byte.parseByte(idx.substring(2));
            res += arr[i] + " ";
        }
        return res;
    }
    
    private void updateShahed() {
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        model.setRowCount(0);
        current.shatibiyyah.stream().forEach((s) -> {
            model.addRow(new Object[]{ "الشاطبية", s.id, 
                getWords(s.part1, s.words, true), getWords(s.part2, s.words, false) });
        });
        current.dorrah.stream().forEach((s) -> {
            model.addRow(new Object[]{ "الدرة", s.id, 
                getWords(s.part1, s.words, true), getWords(s.part2, s.words, false)});
        });
    }
    
    private void initMenues() {
        for (int i = 0; i < Qeraah.array.length; ++i) {
            JMenuItem item = new JMenuItem(Qeraah.array[i].qeraah);
            item.setArmed(true);
            final Qeraah tmp = Qeraah.array[i];
            item.addActionListener((ActionEvent e) -> {
                //addItem(tmp);
                current.rewayaat.add(Rewayah.getByCombinedCode(tmp.code + ".1"));
                current.rewayaat.add(Rewayah.getByCombinedCode(tmp.code + ".2"));
                buildTree();
            });
            jMenu_Qeraah.add(item);
        }
        for (int i = 0; i < Rewayah.array.length; ++i) {
            JMenuItem item = new JMenuItem(Rewayah.array[i].rewayah);
            item.setArmed(true);
            final Rewayah tmp = Rewayah.array[i];
            item.addActionListener((ActionEvent e) -> {
                //addItem(tmp);
                current.rewayaat.add(tmp);
                buildTree();
            });
            jMenuRewayah.add(item);
        }
        for (int i = 0; i < QeraahGroup.array.length; ++i) {
            JMenuItem item = new JMenuItem(QeraahGroup.array[i].name);
            item.setArmed(true);
            final QeraahGroup tmp = QeraahGroup.array[i];
            item.addActionListener((ActionEvent e) -> {
                //addItem(tmp);
                for (Qeraah q : tmp.qeraat) {
                    current.rewayaat.add(Rewayah.getByCombinedCode(q.code + ".1"));
                    current.rewayaat.add(Rewayah.getByCombinedCode(q.code + ".2"));
                }
                buildTree();
            });
            jMenu_Ramz.add(item);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelPreview;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenu jMenuRewayah;
    private javax.swing.JMenu jMenu_Qeraah;
    private javax.swing.JMenu jMenu_Ramz;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JRadioButton jRadioButtonEdgham;
    private javax.swing.JRadioButton jRadioButtonEmalah;
    private javax.swing.JRadioButton jRadioButtonFarsh;
    private javax.swing.JRadioButton jRadioButtonHamz;
    private javax.swing.JRadioButton jRadioButtonMadd;
    private javax.swing.JRadioButton jRadioButtonNaql;
    private javax.swing.JRadioButton jRadioButtonSakt;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTree jTree1;
    // End of variables declaration//GEN-END:variables
}