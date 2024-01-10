## D-Constant_Service Backend API

This API exposes endpoints to manage D-Constant Backend.

**Contact information:**

Physikalisch-Technische Bundesanstalt

https://www.ptb.de

Daniel.Hutzschenreuter@ptb.de

> v1.0.0

Base URL: https://d-si.ptb.de/api/d-constant/

## D-Constant Controller
Controller with endpoints to manage D-Constant-Backend.

## GET Request: d-siConstantJson

Get a list of physical and mathematical constants with data (value,unit, dateTime,uncertainty....).

Request URL: https://d-si.ptb.de/api/d-siConstantJson

#### Response Example

> 200 Response

```json
[
  {
    "id": 1,
    "year": "2018",
    "label": "planckConstant",
    "quantityTypeQUDT": "Action",
    "value": "6.62607015E-34",
    "unit": "\\joule\\hertz\\tothe{-1}",
    "dateTime": "2018-05-20T00:00:00Z",
    "uncertainty": "0.0",
    "distribution": "normal"
  },
  {
    "id": 2,
    "year": "2014",
    "label": "planckConstant",
    "quantityTypeQUDT": "Action",
    "value": "6.626070040E-34",
    "unit": "\\joule\\second",
    "dateTime": "2015-06-25T00:00:00Z",
    "uncertainty": "0.000000081E-34",
    "distribution": "normal"
  },
  {
    "id": 3,
    "year": "2018",
    "label": "speedOfLightInVacuum",
    "quantityTypeQUDT": "Speed",
    "value": "299792458.0",
    "unit": "\\metre\\second\\tothe{-1}",
    "dateTime": "2019-05-20T00:00:00Z",
    "uncertainty": "0.0",
    "distribution": "normal"
  },
  {
    "id": 4,
    "year": "2014",
    "label": "speedOfLightInVacuum",
    "quantityTypeQUDT": "Speed",
    "value": "299792458.0",
    "unit": "\\metre\\second\\tothe{-1}",
    "dateTime": "2015-06-25T00:00:00Z",
    "uncertainty": "0.0",
    "distribution": "normal"
  },
  {
    "id": 5,
    "year": "2018",
    "label": "hyperfineTransitionFrequencyOfCs133",
    "quantityTypeQUDT": "Frequency",
    "value": "9192631770.0",
    "unit": "\\hertz",
    "dateTime": "2019-05-20T00:00:00Z",
    "uncertainty": "0.0",
    "distribution": "normal"
  },
  {
    "id": 6,
    "year": "2006",
    "label": "hyperfineTransitionFrequencyOfCs133",
    "quantityTypeQUDT": "Frequency",
    "value": "9192631770.0",
    "unit": "\\hertz",
    "dateTime": "2006-03-01T00:00:00Z",
    "uncertainty": "0.0",
    "distribution": "normal"
  },
  {
    "id": 7,
    "year": "2018",
    "label": "elementaryCharge",
    "quantityTypeQUDT": "ElectricCharge",
    "value": "1.602176634E-19",
    "unit": "\\coulomb",
    "dateTime": "2019-05-20T00:00:00Z",
    "uncertainty": "0.0",
    "distribution": "normal"
  },
  {
    "id": 8,
    "year": "2014",
    "label": "elementaryCharge",
    "quantityTypeQUDT": "ElectricCharge",
    "value": "1.6021766208E-19",
    "unit": "\\coulomb",
    "dateTime": "2014-05-20T00:00:00Z",
    "uncertainty": "0.0000000098e-19",
    "distribution": "normal"
  },
  {
    "id": 9,
    "year": "2018",
    "label": "boltzmannConstant",
    "quantityTypeQUDT": "HeatCapacity",
    "value": "1.380649E-23",
    "unit": "\\joule\\kelvin\\tothe{-1}",
    "dateTime": "2019-05-20T00:00:00Z",
    "uncertainty": "0.0",
    "distribution": "normal"
  },
  {
    "id": 10,
    "year": "2014",
    "label": "boltzmannConstant",
    "quantityTypeQUDT": "HeatCapacity",
    "value": "1.38064852E-23",
    "unit": "\\joule\\kelvin\\tothe{-1}",
    "dateTime": "2015-05-20T00:00:00Z",
    "uncertainty": "7.9E-30",
    "distribution": "normal"
  },
  {
    "id": 11,
    "year": "2018",
    "label": "avogadroConstant",
    "quantityTypeQUDT": "InverseAmountOfSubstance",
    "value": "6.02214076E23",
    "unit": "\\mole\\tothe{-1}",
    "dateTime": "2019-05-20T00:00:00Z",
    "uncertainty": "0.0",
    "distribution": "normal"
  },
  {
    "id": 12,
    "year": "2014",
    "label": "avogadroConstant",
    "quantityTypeQUDT": "InverseAmountOfSubstance",
    "value": "6.022140857E23",
    "unit": "\\mole\\tothe{-1}",
    "dateTime": "2015-06-25T00:00:00Z",
    "uncertainty": "0.000000074E23",
    "distribution": "normal"
  },
  {
    "id": 13,
    "year": "2018",
    "label": "luminousEfficacy",
    "quantityTypeQUDT": "LuminousFluxPerPower (non QUDT)",
    "value": "683.0",
    "unit": "\\lumen\\watt\\tothe{-1}",
    "dateTime": "2019-05-20T00:00:00Z",
    "uncertainty": "0.0",
    "distribution": "normal"
  },
  {
    "id": 14,
    "year": "2018",
    "label": "protonElectronMassRatio",
    "quantityTypeQUDT": "proton-electron mass ratio",
    "value": "1836.15267343",
    "unit": "\\kilogram\\kilogram\\tothe{-1}",
    "dateTime": "2019-05-20T00:00:00Z",
    "uncertainty": "0.00000011",
    "distribution": "normal"
  },
  {
    "id": 15,
    "year": "2014",
    "label": "protonElectronMassRatio",
    "quantityTypeQUDT": "proton-electron mass ratio",
    "value": "1836.15267389",
    "unit": "\\kilogram\\kilogram\\tothe{-1}",
    "dateTime": "2015-06-25T00:00:00Z",
    "uncertainty": "0.00000017",
    "distribution": "normal"
  },
  {
    "id": 16,
    "year": "Digits8",
    "label": "pi",
    "quantityTypeQUDT": "DimensionlessRatio",
    "value": "3.14159265",
    "unit": "\\metre\\metre\\tothe{-1}",
    "dateTime": "2023-06-12T00:00:00Z",
    "uncertainty": "2.9E-9",
    "distribution": "rectangular"
  },
  {
    "id": 17,
    "year": "Digits16",
    "label": "pi",
    "quantityTypeQUDT": "DimensionlessRatio",
    "value": "3.141592653589793",
    "unit": "\\metre\\metre\\tothe{-1}",
    "dateTime": "2023-06-12T00:00:00Z",
    "uncertainty": "2.9E-17",
    "distribution": "rectangular"
  },
  {
    "id": 18,
    "year": "Digits32",
    "label": "pi",
    "quantityTypeQUDT": "DimensionlessRatio",
    "value": "3.14159265358979323846264338327950",
    "unit": "\\metre\\metre\\tothe{-1}",
    "dateTime": "2023-06-12T00:00:00Z",
    "uncertainty": "2.9E-33",
    "distribution": "rectangular"
  },
  {
    "id": 19,
    "year": "Digits8",
    "label": "e",
    "quantityTypeQUDT": "Dimensionless",
    "value": "2.71828183",
    "unit": "\\one",
    "dateTime": "2023-06-12T00:00:00Z",
    "uncertainty": "2.9E-9",
    "distribution": "rectangular"
  },
  {
    "id": 20,
    "year": "Digits16",
    "label": "e",
    "quantityTypeQUDT": "Dimensionless",
    "value": "2.7182818284590452",
    "unit": "\\one",
    "dateTime": "2023-06-12T00:00:00Z",
    "uncertainty": "2.9E-17",
    "distribution": "rectangular"
  },
  {
    "id": 21,
    "year": "Digits32",
    "label": "e",
    "quantityTypeQUDT": "Dimensionless",
    "value": "2.71828182845904523536028747135266",
    "unit": "\\one",
    "dateTime": "2023-06-12T00:00:00Z",
    "uncertainty": "2.9E-33",
    "distribution": "rectangular"
  }
]
```

### Response

| HTTP Status Code | Meaning | Description          |
|------------------|---------|----------------------|
| 200              | OK      | successful operation |

## GET Request: getConstantByNameSubName

returns XML_Constant by a specific constant name and subname.

Request URL: https://d-si.ptb.de/api/d-constant/{nameSubname}"

### Params

| Name | Location | Type   | Required | Description           |
|------|----------|--------|----------|-----------------------|
| nameSubname | path     | string | true  |constant name and subname |

#### Request Example:

> Request URL: https://d-si.ptb.de/api/d-constant/planckConstant2018

#### Response Example:

```xml

<dsi:planckConstant2018 xmlns:si="https://ptb.de/si" xmlns:dcterms="http://purl.org/dc/terms/"
                        xmlns:dsi="https://ptb.de/si/d-constant" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                        isSIDefining="true" isCOData="true" isMath="false"
                        xsi:schemaLocation="https://ptb.de/si/d-constant constantDataType.xsd">
    <dsi:identifiers>
        <dsi:identifier>
            <dcterms:publisher>DSI</dcterms:publisher>
            <dcterms:identifier>https://ptb.de/si/d-constant/planckConstant2018</dcterms:identifier>
        </dsi:identifier>
        <dsi:identifier>
            <dcterms:publisher>DSI</dcterms:publisher>
            <dcterms:identifier>https://ptb.de/si/d-constant/codata/planckConstant</dcterms:identifier>
        </dsi:identifier>
        <dsi:identifier>
            <dcterms:publisher>BIPM</dcterms:publisher>
            <dcterms:identifier>https://siunits.stuchalk.domains.unf.edu/si/definingconstant/planck_constant
            </dcterms:identifier>
        </dsi:identifier>
        <dsi:identifier>
            <dcterms:publisher>CODATA</dcterms:publisher>
            <dcterms:identifier>https://siunits.stuchalk.domains.unf.edu/si/definingconstant/planck_constant
            </dcterms:identifier>
        </dsi:identifier>
    </dsi:identifiers>
    <dsi:dsiApproved>true</dsi:dsiApproved>
    <si:constant>
        <si:label>planckConstant</si:label>
        <si:quantityTypeQUDT>Action</si:quantityTypeQUDT>
        <si:value>6.62607015E-34</si:value>
        <si:unit>\joule\hertz\tothe{-1}</si:unit>
        <si:dateTime>2018-05-20T00:00:00Z</si:dateTime>
        <si:uncertainty>0.0</si:uncertainty>
        <si:distribution>normal</si:distribution>
    </si:constant>
</dsi:planckConstant2018>
```

### Response

| HTTP Status Code | Meaning | Description | Data schema |
|------------------|---------|-------------|-------------|
| 200              | OK      | OK          | string      |
| 404 /  500?           | ERROR   | the specified constant pid is wrong  | string      |

> 200 Response

> 404 Response





