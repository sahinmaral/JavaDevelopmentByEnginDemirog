import React, { useState,useEffect } from 'react'
import { useParams } from 'react-router-dom'
import { Button, Card, Image } from 'semantic-ui-react'
import ProductService from '../services/productService.js'

export default function ProductDetail() {
    //Parametreleri obje olarak verir
    let { id } = useParams()

    const [product, setProduct] = useState({});

  useEffect(()=>{
    let productService = new ProductService()
    productService.getByProductId(id).then(result=>setProduct(result.data.data))
  },[])


    return (
        <div>
            <Card.Group>
                <Card fluid>
                    <Card.Content>
                        <Image
                            floated='right'
                            size='mini'
                            src='/images/avatar/large/steve.jpg'
                        />
                        <Card.Header>{product.productName}</Card.Header>
                        <Card.Meta>Friends of Elliot</Card.Meta>
                        <Card.Description>
                            Steve wants to add you to the group <strong>best friends</strong>
                        </Card.Description>
                    </Card.Content>
                    <Card.Content extra>
                        <div className='ui two buttons'>
                            <Button basic color='green'>
                                Approve
                            </Button>
                            <Button basic color='red'>
                                Decline
                            </Button>
                        </div>
                    </Card.Content>
                </Card>
                
            </Card.Group>
        </div>
    )
}
