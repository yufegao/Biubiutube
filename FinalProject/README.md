# BiubiuTube

- [BiubiuTube](#biubiutube)
    - [Hierarchical Object Model](#hierarchical-object-model)
    - [Naming Convention](#naming-convention)
        - [Package and Class](#package-and-class)
            - [Example](#example)
        - [UI Elements](#ui-elements)
            - [Example](#example)

## Hierarchical Object Model
![](https://bytebucket.org/zhongjiehe/aed_assignments/raw/d9227c9007e31b4ba002529cdbc7b799bf61326e/FinalProject/Documents/Model.jpg?token=9b5bb207f54cfdaa6687294c3afc2900776a7a8b)

## Naming Convention
### Package and Class
To avoid naming conflicts between package and class, use `lower camel case` or `lower case abbreviation` for any packages and `upper camel case` for classes.  
#### Example
- package
    - `biz`
    - `ui`
    - `topBar`
- class
    - `Business`
    - `AdDepartment`

### UI Elements
Elements that might be accessed manually in `.java` should have a abbreviation prefix.

#### Example
| class        | prefix | example     |
|--------------|--------|-------------|
| JLabel       | lbl    | lblTitle    |
| JButton      | btn    | btnAdd      |
| JTable       | tbl    | tblOrder    |
| JTextField   | txt    | txtUsername |
| JPassword    | txt    | txtPassword |
| JComboBox    | cb     | cbState     |
| JCheckBox    | ck     | ckEnabled   |
| JRadioButton | rb     | rbMale      |