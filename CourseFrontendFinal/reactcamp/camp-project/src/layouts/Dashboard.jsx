import React from 'react'
import ProductList from '../pages/ProductList'
import Categories from './Categories'
import { Grid } from 'semantic-ui-react'
import {Route} from 'react-router-dom'
import ProductDetail from '../pages/ProductDetail'
import CartDetail from '../pages/CartDetail'

export default function Dashboard() {
    return (
        <div>
            <Grid>
            <Grid.Row>
                <Grid.Column width={4}>
                    <Categories />
                </Grid.Column>
                
                

                <Grid.Column width={12}>
                    {/* Eğer anasayfa gelirse component olarak ProductList getir */}
                    {/* exact ifadesi , İngilizce'den de anlaşıldığı gibi yazılan ifadeyle aynı olacak */}
                    <Route exact path="/" component={ProductList}/>
                     {/* Eğer products gelirse component olarak Products getir */}
                     <Route exact path="/products" component={ProductList}/>
                     {/* :id , parametre aldığını belirtir */}
                    <Route path="/products/:id" component={ProductDetail}/>
                    <Route path="/cart" component={CartDetail}/>
                </Grid.Column>

            </Grid.Row>
            </Grid>
        </div>
    )
}
