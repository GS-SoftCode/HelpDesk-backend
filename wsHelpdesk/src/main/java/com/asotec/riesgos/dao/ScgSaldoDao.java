package com.asotec.riesgos.dao;

import com.asotec.riesgos.entity.ScgCuenta;
import com.asotec.riesgos.entity.ScgSaldos;
import org.springframework.stereotype.Repository;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author josesanchez
 */
@Repository
public class ScgSaldoDao extends GenericDao<ScgSaldos> implements IScgSaldoDao {

    /**
     * Constructor general
     */
    public ScgSaldoDao() {
        super();
        setClase(ScgSaldos.class);
    }

    @Override
    public List<ScgSaldos> findAllL02(String[] fechaFormat) {
        //NOTA: Usando SELECT camp1, camp2, etc... se recupera una lista de listas y no una lista de objetos de tipo ScgSaldos
        String sql = "SELECT c.codCuenta, c.nomCuenta,"
                    + " CASE "
                    + " WHEN c.codCuenta like '15%' THEN 'AD15' WHEN c.codCuenta like '16%' THEN 'AC16' WHEN c.codCuenta like '17%' THEN 'AB17' WHEN c.codCuenta like '18%' THEN 'AP18' WHEN c.codCuenta like '19%' THEN 'AO19' WHEN c.codCuenta like '22%' THEN 'PO22' WHEN c.codCuenta like '23%' THEN 'PO23' WHEN c.codCuenta like '24%' THEN 'PA24' WHEN c.codCuenta like '25%' THEN 'PC25' WHEN c.codCuenta like '29%' THEN 'PO29' WHEN c.codCuenta like '1301%' THEN 'AA1301' " +
                        "WHEN c.codCuenta like '1302%' THEN 'AA1302' WHEN c.codCuenta like '1303%' THEN 'AD1303' WHEN c.codCuenta like '1304%' THEN 'AD1304' WHEN c.codCuenta like '1305%' THEN 'AM1305' WHEN c.codCuenta like '1306%' THEN 'AM1306' WHEN c.codCuenta like '1307%' THEN 'AD1307' WHEN c.codCuenta like '1401%' THEN 'AC1401' WHEN c.codCuenta like '1402%' THEN 'AC1402' WHEN c.codCuenta like '1403%' THEN 'AC1403' WHEN c.codCuenta like '1404%' THEN 'AC1404' " +
                        "WHEN c.codCuenta like '1408%' THEN 'AC1408' WHEN c.codCuenta like '1409%' THEN 'AC1409' WHEN c.codCuenta like '1410%' THEN 'AC1410' WHEN c.codCuenta like '1411%' THEN 'AC1411' WHEN c.codCuenta like '1412%' THEN 'AC1412' WHEN c.codCuenta like '1416%' THEN 'AC1416' WHEN c.codCuenta like '1417%' THEN 'AC1417' WHEN c.codCuenta like '1418%' THEN 'AC1418' WHEN c.codCuenta like '1419%' THEN 'AC1419' WHEN c.codCuenta like '1420%' THEN 'AC1420' " +
                        "WHEN c.codCuenta like '1424%' THEN 'AC1424' WHEN c.codCuenta like '1425%' THEN 'AC1425' WHEN c.codCuenta like '1426%' THEN 'AC1426' WHEN c.codCuenta like '1427%' THEN 'AC1427' WHEN c.codCuenta like '1428%' THEN 'AC1428' WHEN c.codCuenta like '1432%' THEN 'AC1432' WHEN c.codCuenta like '1433%' THEN 'AC1433' WHEN c.codCuenta like '1434%' THEN 'AC1434' WHEN c.codCuenta like '1435%' THEN 'AC1435' WHEN c.codCuenta like '1436%' THEN 'AC1436' " +
                        "WHEN c.codCuenta like '1440%' THEN 'AC1440' WHEN c.codCuenta like '1441%' THEN 'AC1441' WHEN c.codCuenta like '1442%' THEN 'AC1442' WHEN c.codCuenta like '1443%' THEN 'AC1443' WHEN c.codCuenta like '1444%' THEN 'AC1444' WHEN c.codCuenta like '1448%' THEN 'AC1448' WHEN c.codCuenta like '1449%' THEN 'AC1449' WHEN c.codCuenta like '1450%' THEN 'AC1450' WHEN c.codCuenta like '1451%' THEN 'AC1451' WHEN c.codCuenta like '1452%' THEN 'AC1452' " +
                        "WHEN c.codCuenta like '1456%' THEN 'AC1456' WHEN c.codCuenta like '1457%' THEN 'AC1457' WHEN c.codCuenta like '1458%' THEN 'AC1458' WHEN c.codCuenta like '1459%' THEN 'AC1459' WHEN c.codCuenta like '1460%' THEN 'AC1460' WHEN c.codCuenta like '1464%' THEN 'AC1464' WHEN c.codCuenta like '1465%' THEN 'AC1465' WHEN c.codCuenta like '1466%' THEN 'AC1466' WHEN c.codCuenta like '1467%' THEN 'AC1467' WHEN c.codCuenta like '1468%' THEN 'AC1468' " +
                        "WHEN c.codCuenta like '1472%' THEN 'AC1472' WHEN c.codCuenta like '1473%' THEN 'AC1473' WHEN c.codCuenta like '1475%' THEN 'AC1475' WHEN c.codCuenta like '1477%' THEN 'AC1477' WHEN c.codCuenta like '1479%' THEN 'AC1479' WHEN c.codCuenta like '1481%' THEN 'AC1481' WHEN c.codCuenta like '1483%' THEN 'AC1483' WHEN c.codCuenta like '1485%' THEN 'AC1485' WHEN c.codCuenta like '1487%' THEN 'AC1487' WHEN c.codCuenta like '1489%' THEN 'AC1489' " +
                        "WHEN c.codCuenta like '2101%' THEN 'PD2101' WHEN c.codCuenta like '2103%' THEN 'PD2103' WHEN c.codCuenta like '2104%' THEN 'PD2104' WHEN c.codCuenta like '2105%' THEN 'PD2105' WHEN c.codCuenta like '2601%' THEN 'PS2601' WHEN c.codCuenta like '2602%' THEN 'PO2602' WHEN c.codCuenta like '2603%' THEN 'PO2603' WHEN c.codCuenta like '2604%' THEN 'PO2604' WHEN c.codCuenta like '2606%' THEN 'PO2606' WHEN c.codCuenta like '2607%' THEN 'PO2607' " +
                        "WHEN c.codCuenta like '2608%' THEN 'PP2608' WHEN c.codCuenta like '2609%' THEN 'PO2609' WHEN c.codCuenta like '2610%' THEN 'PO2610' WHEN c.codCuenta like '2690%' THEN 'PO2690' WHEN c.codCuenta like '2701%' THEN 'PB2701' WHEN c.codCuenta like '2702%' THEN 'PO2702' WHEN c.codCuenta like '2703%' THEN 'PO2703' WHEN c.codCuenta like '2790%' THEN 'PP2790' WHEN c.codCuenta like '6190%' THEN 'CO6190' WHEN c.codCuenta like '6401%' THEN 'CA6401' " +
                        "WHEN c.codCuenta like '6402%' THEN 'CF6402' WHEN c.codCuenta like '6403%' THEN 'CC6403' WHEN c.codCuenta like '6404%' THEN 'CC6404' WHEN c.codCuenta like '6405%' THEN 'CC6405' WHEN c.codCuenta like '6412%' THEN 'CG6412' WHEN c.codCuenta like '6490%' THEN 'CO6490' "
                    + " ELSE 'NaN' "
                    + " END AS codBrecha, "
                    + " CASE WHEN c.numDA = 1 THEN (s.valDebitos - s.valCreditos) WHEN c.numDA = -1 THEN (s.valCreditos - s.valDebitos) ELSE 0.00 END AS saldo, "
                    + " s.id.codAaa, s.id.codMes"
                    + " from " + ScgCuenta.class.getName() + " c "
                    + " INNER JOIN "+ ScgSaldos.class.getName() + " s ON s.id.codCuenta = c.codCuenta "
                + " where ("
                + " c.codCuenta like '15%' or c.codCuenta like '16%' or c.codCuenta like '17%' or c.codCuenta like '18%' or c.codCuenta like '19%' or c.codCuenta like '22%' or c.codCuenta like '23%' or c.codCuenta like '24%' or c.codCuenta like '25%' or c.codCuenta like '29%' or " +
                    "c.codCuenta like '1301%' or c.codCuenta like '1302%' or c.codCuenta like '1303%' or c.codCuenta like '1304%' or c.codCuenta like '1305%' or c.codCuenta like '1306%' or c.codCuenta like '1307%' or c.codCuenta like '1401%' or c.codCuenta like '1402%' or c.codCuenta like '1403%' or " +
                    "c.codCuenta like '1404%' or c.codCuenta like '1408%' or c.codCuenta like '1409%' or c.codCuenta like '1410%' or c.codCuenta like '1411%' or c.codCuenta like '1412%' or c.codCuenta like '1416%' or c.codCuenta like '1417%' or c.codCuenta like '1418%' or c.codCuenta like '1419%' or " +
                    "c.codCuenta like '1420%' or c.codCuenta like '1424%' or c.codCuenta like '1425%' or c.codCuenta like '1426%' or c.codCuenta like '1427%' or c.codCuenta like '1428%' or c.codCuenta like '1432%' or c.codCuenta like '1433%' or c.codCuenta like '1434%' or c.codCuenta like '1435%' or " +
                    "c.codCuenta like '1436%' or c.codCuenta like '1440%' or c.codCuenta like '1441%' or c.codCuenta like '1442%' or c.codCuenta like '1443%' or c.codCuenta like '1444%' or c.codCuenta like '1448%' or c.codCuenta like '1449%' or c.codCuenta like '1450%' or c.codCuenta like '1451%' or " +
                    "c.codCuenta like '1452%' or c.codCuenta like '1456%' or c.codCuenta like '1457%' or c.codCuenta like '1458%' or c.codCuenta like '1459%' or c.codCuenta like '1460%' or c.codCuenta like '1464%' or c.codCuenta like '1465%' or c.codCuenta like '1466%' or c.codCuenta like '1467%' or " +
                    "c.codCuenta like '1468%' or c.codCuenta like '1472%' or c.codCuenta like '1473%' or c.codCuenta like '1475%' or c.codCuenta like '1477%' or c.codCuenta like '1479%' or c.codCuenta like '1481%' or c.codCuenta like '1483%' or c.codCuenta like '1485%' or c.codCuenta like '1487%' or " +
                    "c.codCuenta like '1489%' or c.codCuenta like '2101%' or c.codCuenta like '2103%' or c.codCuenta like '2104%' or c.codCuenta like '2105%' or c.codCuenta like '2601%' or c.codCuenta like '2602%' or c.codCuenta like '2603%' or c.codCuenta like '2604%' or c.codCuenta like '2606%' or " +
                    "c.codCuenta like '2607%' or c.codCuenta like '2608%' or c.codCuenta like '2609%' or c.codCuenta like '2610%' or c.codCuenta like '2690%' or c.codCuenta like '2701%' or c.codCuenta like '2702%' or c.codCuenta like '2703%' or c.codCuenta like '2790%' or c.codCuenta like '6190%' or " +
                    "c.codCuenta like '6401%' or c.codCuenta like '6402%' or c.codCuenta like '6403%' or c.codCuenta like '6404%' or c.codCuenta like '6405%' or c.codCuenta like '6412%' or c.codCuenta like '6490%' "
                + " ) and c.nomCuenta like '%días' and c.nomCuenta NOT like 'Depósitos%' and c.nomCuenta != 'De 1 a 30 días' and c.nomCuenta != 'De 31 a 90 días' and c.nomCuenta != 'De 91 a 270 días' and c.nomCuenta != 'De 271 a 360 días' and c.nomCuenta != 'De 361 a 720 días' and s.id.codAaa = "+fechaFormat[0]+" and s.id.codMes = "+Long.parseLong(fechaFormat[1])+" "
                + " order by c.codCuenta";
        System.out.println("SQL: "+sql);
        Query query = entityManager.createQuery(sql);
        return query.getResultList();
    }

    @Override
    public List<Object> findbyDateL02(String[] fechaFormat) {

        //NOTA:: codigo de escenario revisar
        String sql = "select c.codCuenta, c.numDA, "
                    + " CASE WHEN c.numDA = 1 THEN (s.valDebitos - s.valCreditos) WHEN c.numDA = -1 THEN (s.valCreditos - s.valDebitos) ELSE 0.00 END AS saldo, "
                    + " CASE "
                    + " WHEN c.codCuenta like '15%' THEN 'AD15' WHEN c.codCuenta like '16%' THEN 'AC16' WHEN c.codCuenta like '17%' THEN 'AB17' WHEN c.codCuenta like '18%' THEN 'AP18' WHEN c.codCuenta like '19%' THEN 'AO19' WHEN c.codCuenta like '22%' THEN 'PO22' WHEN c.codCuenta like '23%' THEN 'PO23' WHEN c.codCuenta like '24%' THEN 'PA24' WHEN c.codCuenta like '25%' THEN 'PC25' WHEN c.codCuenta like '29%' THEN 'PO29' WHEN c.codCuenta like '1301%' THEN 'AA1301' " +
                        "WHEN c.codCuenta like '1302%' THEN 'AA1302' WHEN c.codCuenta like '1303%' THEN 'AD1303' WHEN c.codCuenta like '1304%' THEN 'AD1304' WHEN c.codCuenta like '1305%' THEN 'AM1305' WHEN c.codCuenta like '1306%' THEN 'AM1306' WHEN c.codCuenta like '1307%' THEN 'AD1307' WHEN c.codCuenta like '1401%' THEN 'AC1401' WHEN c.codCuenta like '1402%' THEN 'AC1402' WHEN c.codCuenta like '1403%' THEN 'AC1403' WHEN c.codCuenta like '1404%' THEN 'AC1404' " +
                        "WHEN c.codCuenta like '1408%' THEN 'AC1408' WHEN c.codCuenta like '1409%' THEN 'AC1409' WHEN c.codCuenta like '1410%' THEN 'AC1410' WHEN c.codCuenta like '1411%' THEN 'AC1411' WHEN c.codCuenta like '1412%' THEN 'AC1412' WHEN c.codCuenta like '1416%' THEN 'AC1416' WHEN c.codCuenta like '1417%' THEN 'AC1417' WHEN c.codCuenta like '1418%' THEN 'AC1418' WHEN c.codCuenta like '1419%' THEN 'AC1419' WHEN c.codCuenta like '1420%' THEN 'AC1420' " +
                        "WHEN c.codCuenta like '1424%' THEN 'AC1424' WHEN c.codCuenta like '1425%' THEN 'AC1425' WHEN c.codCuenta like '1426%' THEN 'AC1426' WHEN c.codCuenta like '1427%' THEN 'AC1427' WHEN c.codCuenta like '1428%' THEN 'AC1428' WHEN c.codCuenta like '1432%' THEN 'AC1432' WHEN c.codCuenta like '1433%' THEN 'AC1433' WHEN c.codCuenta like '1434%' THEN 'AC1434' WHEN c.codCuenta like '1435%' THEN 'AC1435' WHEN c.codCuenta like '1436%' THEN 'AC1436' " +
                        "WHEN c.codCuenta like '1440%' THEN 'AC1440' WHEN c.codCuenta like '1441%' THEN 'AC1441' WHEN c.codCuenta like '1442%' THEN 'AC1442' WHEN c.codCuenta like '1443%' THEN 'AC1443' WHEN c.codCuenta like '1444%' THEN 'AC1444' WHEN c.codCuenta like '1448%' THEN 'AC1448' WHEN c.codCuenta like '1449%' THEN 'AC1449' WHEN c.codCuenta like '1450%' THEN 'AC1450' WHEN c.codCuenta like '1451%' THEN 'AC1451' WHEN c.codCuenta like '1452%' THEN 'AC1452' " +
                        "WHEN c.codCuenta like '1456%' THEN 'AC1456' WHEN c.codCuenta like '1457%' THEN 'AC1457' WHEN c.codCuenta like '1458%' THEN 'AC1458' WHEN c.codCuenta like '1459%' THEN 'AC1459' WHEN c.codCuenta like '1460%' THEN 'AC1460' WHEN c.codCuenta like '1464%' THEN 'AC1464' WHEN c.codCuenta like '1465%' THEN 'AC1465' WHEN c.codCuenta like '1466%' THEN 'AC1466' WHEN c.codCuenta like '1467%' THEN 'AC1467' WHEN c.codCuenta like '1468%' THEN 'AC1468' " +
                        "WHEN c.codCuenta like '1472%' THEN 'AC1472' WHEN c.codCuenta like '1473%' THEN 'AC1473' WHEN c.codCuenta like '1475%' THEN 'AC1475' WHEN c.codCuenta like '1477%' THEN 'AC1477' WHEN c.codCuenta like '1479%' THEN 'AC1479' WHEN c.codCuenta like '1481%' THEN 'AC1481' WHEN c.codCuenta like '1483%' THEN 'AC1483' WHEN c.codCuenta like '1485%' THEN 'AC1485' WHEN c.codCuenta like '1487%' THEN 'AC1487' WHEN c.codCuenta like '1489%' THEN 'AC1489' " +
                        "WHEN c.codCuenta like '2101%' THEN 'PD2101' WHEN c.codCuenta like '2103%' THEN 'PD2103' WHEN c.codCuenta like '2104%' THEN 'PD2104' WHEN c.codCuenta like '2105%' THEN 'PD2105' WHEN c.codCuenta like '2601%' THEN 'PS2601' WHEN c.codCuenta like '2602%' THEN 'PO2602' WHEN c.codCuenta like '2603%' THEN 'PO2603' WHEN c.codCuenta like '2604%' THEN 'PO2604' WHEN c.codCuenta like '2606%' THEN 'PO2606' WHEN c.codCuenta like '2607%' THEN 'PO2607' " +
                        "WHEN c.codCuenta like '2608%' THEN 'PP2608' WHEN c.codCuenta like '2609%' THEN 'PO2609' WHEN c.codCuenta like '2610%' THEN 'PO2610' WHEN c.codCuenta like '2690%' THEN 'PO2690' WHEN c.codCuenta like '2701%' THEN 'PB2701' WHEN c.codCuenta like '2702%' THEN 'PO2702' WHEN c.codCuenta like '2703%' THEN 'PO2703' WHEN c.codCuenta like '2790%' THEN 'PP2790' WHEN c.codCuenta like '6190%' THEN 'CO6190' WHEN c.codCuenta like '6401%' THEN 'CA6401' " +
                        "WHEN c.codCuenta like '6402%' THEN 'CF6402' WHEN c.codCuenta like '6403%' THEN 'CC6403' WHEN c.codCuenta like '6404%' THEN 'CC6404' WHEN c.codCuenta like '6405%' THEN 'CC6405' WHEN c.codCuenta like '6412%' THEN 'CG6412' WHEN c.codCuenta like '6490%' THEN 'CO6490' "
                    + " ELSE 'NaN' END AS cod_brecha, "
                    + " CASE "
                    + " WHEN c.codCuenta like '15%' THEN 'C' ELSE 'C' END AS escenario  "
                    + " from " + ScgCuenta.class.getName() + " c "
                + " INNER JOIN "+ ScgSaldos.class.getName() + " s ON s.id.codCuenta = c.codCuenta "
                + " where ("
                + " c.codCuenta like '15%' or c.codCuenta like '16%' or c.codCuenta like '17%' or c.codCuenta like '18%' or c.codCuenta like '19%' or c.codCuenta like '22%' or c.codCuenta like '23%' or c.codCuenta like '24%' or c.codCuenta like '25%' or c.codCuenta like '29%' or " +
                    "c.codCuenta like '1301%' or c.codCuenta like '1302%' or c.codCuenta like '1303%' or c.codCuenta like '1304%' or c.codCuenta like '1305%' or c.codCuenta like '1306%' or c.codCuenta like '1307%' or c.codCuenta like '1401%' or c.codCuenta like '1402%' or c.codCuenta like '1403%' or " +
                    "c.codCuenta like '1404%' or c.codCuenta like '1408%' or c.codCuenta like '1409%' or c.codCuenta like '1410%' or c.codCuenta like '1411%' or c.codCuenta like '1412%' or c.codCuenta like '1416%' or c.codCuenta like '1417%' or c.codCuenta like '1418%' or c.codCuenta like '1419%' or " +
                    "c.codCuenta like '1420%' or c.codCuenta like '1424%' or c.codCuenta like '1425%' or c.codCuenta like '1426%' or c.codCuenta like '1427%' or c.codCuenta like '1428%' or c.codCuenta like '1432%' or c.codCuenta like '1433%' or c.codCuenta like '1434%' or c.codCuenta like '1435%' or " +
                    "c.codCuenta like '1436%' or c.codCuenta like '1440%' or c.codCuenta like '1441%' or c.codCuenta like '1442%' or c.codCuenta like '1443%' or c.codCuenta like '1444%' or c.codCuenta like '1448%' or c.codCuenta like '1449%' or c.codCuenta like '1450%' or c.codCuenta like '1451%' or " +
                    "c.codCuenta like '1452%' or c.codCuenta like '1456%' or c.codCuenta like '1457%' or c.codCuenta like '1458%' or c.codCuenta like '1459%' or c.codCuenta like '1460%' or c.codCuenta like '1464%' or c.codCuenta like '1465%' or c.codCuenta like '1466%' or c.codCuenta like '1467%' or " +
                    "c.codCuenta like '1468%' or c.codCuenta like '1472%' or c.codCuenta like '1473%' or c.codCuenta like '1475%' or c.codCuenta like '1477%' or c.codCuenta like '1479%' or c.codCuenta like '1481%' or c.codCuenta like '1483%' or c.codCuenta like '1485%' or c.codCuenta like '1487%' or " +
                    "c.codCuenta like '1489%' or c.codCuenta like '2101%' or c.codCuenta like '2103%' or c.codCuenta like '2104%' or c.codCuenta like '2105%' or c.codCuenta like '2601%' or c.codCuenta like '2602%' or c.codCuenta like '2603%' or c.codCuenta like '2604%' or c.codCuenta like '2606%' or " +
                    "c.codCuenta like '2607%' or c.codCuenta like '2608%' or c.codCuenta like '2609%' or c.codCuenta like '2610%' or c.codCuenta like '2690%' or c.codCuenta like '2701%' or c.codCuenta like '2702%' or c.codCuenta like '2703%' or c.codCuenta like '2790%' or c.codCuenta like '6190%' or " +
                    "c.codCuenta like '6401%' or c.codCuenta like '6402%' or c.codCuenta like '6403%' or c.codCuenta like '6404%' or c.codCuenta like '6405%' or c.codCuenta like '6412%' or c.codCuenta like '6490%' "
                + " ) and c.nomCuenta like '%días' and c.nomCuenta NOT like 'Depósitos%' and c.nomCuenta != 'De 1 a 30 días' and c.nomCuenta != 'De 31 a 90 días' and c.nomCuenta != 'De 91 a 270 días' and c.nomCuenta != 'De 271 a 360 días' and c.nomCuenta != 'De 361 a 720 días' and s.id.codAaa = "+fechaFormat[0]+" and s.id.codMes = "+Long.parseLong(fechaFormat[1])+" "
                + " order by c.codCuenta";
        System.out.println("SQL: "+sql);
        Query query = entityManager.createQuery(sql);
        return query.getResultList();
    }

    /*
      * Filtra
     *
     * @return registros
     */
    @Override
    public List<ScgSaldos> findAll() {
        String sql = "SELECT c.codCuenta, "
                    + " CASE "
                    + " WHEN c.codCuenta like '15%' THEN 'AD15' "
                    + " WHEN c.codCuenta like '16%' THEN 'AD16' "
                    + " ELSE 'NaN' "
                    + " END AS codBrecha, "
                    + " CASE WHEN c.numDA = 1 THEN (s.valDebitos - s.valCreditos) WHEN c.numDA = -1 THEN (s.valCreditos - s.valDebitos) ELSE 0.00 END AS saldo, "
                    + " s.id.codAaa, s.id.codMes"
                    + " from " + ScgCuenta.class.getName() + " c "
                    + " INNER JOIN "+ ScgSaldos.class.getName() + " s ON s.id.codCuenta = c.codCuenta "
                + " where (c.codCuenta like '15%' or c.codCuenta like '16%' ) and c.nomCuenta like '%días' "
                + " order by s.id.codAaa desc";
        System.out.println("SQL: "+sql);        
        Query query = entityManager.createQuery(sql);
        return query.getResultList();
    }

    @Override
    public List<ScgSaldos> findByFecha() {
        String sql = "select distinct(id.codAaa) as codAaa, id.codMes, sum(valCreditos - valDebitos) from " + ScgSaldos.class.getName() + ""
                + " where id.codMes <> 0 group by id.codAaa, id.codMes order by id.codAaa, id.codMes asc";
        Query query = entityManager.createQuery(sql);
        return query.getResultList();
    }

    

    
}
